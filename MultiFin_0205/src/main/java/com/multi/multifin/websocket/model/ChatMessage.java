package com.multi.multifin.websocket.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ChatMessage {
    private String content;
    @JsonSerialize(using = MultiLinkSerializer.class)
    private List<MultiLink> multiLink;
    
    public List<MultiLink> getMultiLink() {
		return multiLink;
	}

    public void setMultiLink(List<MultiLink> multiLink) {
		this.multiLink = multiLink;
	}
}