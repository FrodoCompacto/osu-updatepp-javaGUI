public class Loop extends Thread {

    private int ms = 10;
    private boolean running;
    private String url;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Loop(int ms, String link) {
        this.running = true;
        this.ms = ms;
        this.url = link;
        start();
    }

    public void run() {
        while (this.running) {
            try {
                String json = UrlMan.readUrl(this.url);
                TxtMan.writeOnTxt(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(this.ms*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopLoop() {
        this.running = false;
    }
}