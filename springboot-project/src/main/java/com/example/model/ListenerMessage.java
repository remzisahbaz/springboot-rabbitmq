package com.example.model;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@Setter
public class ListenerMessage implements Serializable {

    private String id;
    private Date createDate;
    private boolean isSeen;
    private String messageText;

}
