package com.multi.multifin.websocket.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.multi.multifin.member.model.vo.Member;

// TODO 챗컨트롤러 안됨
@Controller
public class ChatController {

	private static String secretKey = "c1dLUEN1UkpIckFvV0RlSHJOTlBhSEJzY1FWR3ZHU2Y="; // 멀티핀 키 맞음
	private static String apiUrl = "https://f3bbs2i6e0.apigw.ntruss.com/custom/v1/9043/2e43464f12bb51b32e1c338311b36cb22eb5b7cb662d83f2383014a504c63934"; // 멀티핀
																																							// apiUrl
																																							// 맞음

	@RequestMapping("/common/chatbot")
	public String chatbot(@SessionAttribute(name = "loginMember", required = false) Member loginMember, Model model) {
		model.addAttribute("loginMember", loginMember);
		return "/common/chatbot";
	}

	@MessageMapping("/sendMessage")
	@SendTo("/topic/public")
	public String sendMessage(@Payload String userChat) throws IOException, Exception {

		URL url = new URL(apiUrl);

		String message = getReqMessage(userChat);
		String encodeBase64String = makeSignature(message, secretKey);

		// api서버 접속 (서버 -> 서버 통신)
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;UTF-8");
		con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		wr.write(message.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();

		if (responseCode != 200) {
			String chatMessage = con.getResponseMessage();
			System.out.println(chatMessage);
			con.disconnect();
			return null;
		}

//			BufferedReader in = new BufferedReader(
//                    new InputStreamReader(
//                            con.getInputStream(), "UTF-8"));
//            String decodedString;
//            String jsonString = "";
//            while ((decodedString = in.readLine()) != null) {
//                jsonString = decodedString;
//            }

		StringBuilder sb = new StringBuilder();
		try (InputStreamReader isr = new InputStreamReader(con.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);) {
			String decodedString;
			while ((decodedString = br.readLine()) != null) {
				sb.append(decodedString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuilder answer = new StringBuilder();
		if (sb.indexOf("template") > 0) {
			System.out.println(sb.toString());
			// 받아온 값을 세팅하는 부분
			JSONParser jsonparser = new JSONParser();
			JSONObject json = (JSONObject) jsonparser.parse(sb.toString());
			JSONArray bubblesArray = (JSONArray) json.get("bubbles");
			JSONObject bubbles = (JSONObject) bubblesArray.get(0);
			JSONObject data = (JSONObject) bubbles.get("data");
			JSONObject cover = (JSONObject) data.get("cover");
			JSONObject innerData = (JSONObject) cover.get("data");
			String description = (String) innerData.get("description");
			answer.append(description + "<br><br>");

			JSONArray contentTableArray = (JSONArray) data.get("contentTable");
			for (int i = 0; i < contentTableArray.size(); i++) {
				JSONObject item = (JSONObject) ((JSONArray) contentTableArray.get(i)).get(0);
				JSONObject innerData2 = (JSONObject) item.get("data");
				String title = (String) innerData2.get("title");
				JSONObject innerData3 = (JSONObject) innerData2.get("data");
				JSONObject action = (JSONObject) innerData3.get("action");
				JSONObject innerData4 = (JSONObject) action.get("data");
				String postback = (String) innerData4.get("postback");
				
				answer.append("<input id=\"linkBtn"+ postback+ i + "\" type=\"button\" class=\"linkBtn\" value=\"" + title +"\" onclick=\"sendMessage2(\'" + postback + i + "\')\"></input>");
			}

			String url2 = (String) data.get("url");
			if (url2 != null) {
				answer.append(" <a target=\"_blank\" href=\"" + url2 + "\">" + "링크" + "</a>");
			}
		} else {
			// 받아온 값을 세팅하는 부분
			JSONParser jsonparser = new JSONParser();
			JSONObject json = (JSONObject) jsonparser.parse(sb.toString());
			JSONArray bubblesArray = (JSONArray) json.get("bubbles");
			JSONObject bubbles = (JSONObject) bubblesArray.get(0);
			JSONObject data = (JSONObject) bubbles.get("data");
			String description = (String) data.get("description");
			String url2 = (String) data.get("url");
			answer.append(description);
			if (url2 != null) {
				answer.append(" <a target=\"_blank\" href=\"" + url2 + "\">" + "링크" + "</a>");
			}
			answer.append("<br>");
		}
		

//		in.close();

		return answer.toString();
	}

	// 보낼 메세지를 네이버에서 제공해준 암호화로 변경해주는 메소드
	public static String makeSignature(String message, String secretKey) {

		String encodeBase64String = "";

		try {
			byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

			SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);

			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.encodeBase64String(rawHmac);

			return encodeBase64String;

		} catch (Exception e) {
			System.out.println(e);
		}

		return encodeBase64String;

	}

	// 보낼 메세지를 네이버 챗봇에 포맷으로 변경해주는 메소드
	public static String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##" + timestamp);

			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.add(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e) {
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}
}