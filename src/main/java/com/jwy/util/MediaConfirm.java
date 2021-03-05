package com.jwy.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaConfirm {
	private static Map<String, MediaType> mediaMap;
	
	static {  // static 멤버의 초기화 블럭 (Java 기본문법 확인)
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("jpg", MediaType.IMAGE_JPEG);
		mediaMap.put("jpeg", MediaType.IMAGE_JPEG);
		mediaMap.put("gif", MediaType.IMAGE_GIF);
		mediaMap.put("png", MediaType.IMAGE_PNG);
	}
	
	public static MediaType getMediaType(String ext) {
//		mediaMap.containsKey(ext);  // 해보기
		return mediaMap.get(ext.toLowerCase());
	}
}
