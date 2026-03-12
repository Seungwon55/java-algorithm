package ch07;

public class Practice07_11 {
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();

        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setChannel(20);
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
    }
}

class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int prevChannel;

    static final int MAX_VOLUME = 100;
    static final int MIN_VOLUME = 0;
    static final int MAX_CHANNEL = 100;
    static final int MIN_CHANNEL = 1;

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        // 최소, 최대 볼륨을 넘어가지 못하도록 설정
        if (channel < MIN_CHANNEL || channel > MAX_CHANNEL)
            return;

        this.prevChannel = this.channel;
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < MIN_VOLUME || volume > MAX_VOLUME)
            return;

        this.volume = volume;
    }

    // 이전 채널로 이동
    public void gotoPrevChannel() {
        setChannel(prevChannel);
    }
}
