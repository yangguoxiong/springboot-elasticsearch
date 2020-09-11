package com.mark.springboot.elasticsearch.bean;

import lombok.Data;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import java.util.Date;
import java.util.Map;

@Data
public class Twitter {

    private Long id;

    private String user;

    private Date postDate;

    private String message;

    private Map<String, HighlightField> highlight;


}