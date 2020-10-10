package com.just.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class LiveDecoder extends ReplayingDecoder<LiveDecoder.LiveState> {

    public LiveDecoder() {
        super(LiveState.LENGTH);
    }

    public class LiveMessage {
        // 内容
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLength() {
            return content.length();
        }
    }

    private LiveMessage liveMessage = new LiveMessage();

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        switch (state()) {
            case LENGTH:
                int length = byteBuf.readInt();
                if (length > 0) {
                    checkpoint(LiveState.CONTENT);
                }else {
                    list.add(liveMessage);
                }
                break;
            case CONTENT:
                byte[] bytes = new byte[liveMessage.getLength()];
                byteBuf.readBytes(bytes);
                String content = new String(bytes);
                liveMessage.setContent(content);
                list.add(liveMessage);
                break;
            default:
                throw new IllegalStateException("invalid state" + state());
        }
    }

    public enum  LiveState{
        LENGTH,
        CONTENT
    }
}
