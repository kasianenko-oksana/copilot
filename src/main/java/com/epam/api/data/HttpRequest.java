package com.epam.api.data;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class HttpRequest {

  private String body;
  private Map<String, Object> headers;
  private String url;
  private String path;
}
