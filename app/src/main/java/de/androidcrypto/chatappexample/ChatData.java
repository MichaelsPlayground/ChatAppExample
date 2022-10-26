package de.androidcrypto.chatappexample;

public class ChatData {
    private String content;
    private boolean isMine;
    public ChatData(String content,boolean isMine){
        this.content =content;
        this.isMine=isMine;
    }
    public String getContent(){
        return content;
    }
    public boolean isMine(){
        return  isMine;
    }
}