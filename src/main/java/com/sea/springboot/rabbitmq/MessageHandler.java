package com.sea.springboot.rabbitmq;

public class MessageHandler {

    /**
     * 如果没有显式设置默认处理方法，handleMessage方法为默认处理方法
     * @param message
     */
    public void handleMessage(byte[] message){
        System.out.println("---------handleMessage-------------");
        System.out.println(new String(message));
    }

    //以下指定不同的队列不同的处理方法名
    public void onTest(byte[] message){
        System.out.println(new String(message));
    }

    public void onTest2(byte[] message){
        System.out.println(new String(message));
    }
}
