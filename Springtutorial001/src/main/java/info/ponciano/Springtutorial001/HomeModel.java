package info.ponciano.Springtutorial001;

public class HomeModel implements Runnable {
    private Progress progress;
    private DataModel data;

    public HomeModel() {
        this.progress = new Progress(-1, "No work in process");
        this.data = new DataModel(1, "Ponciano");
    }

    public Progress getProgress() {
        return progress;
    }

    public DataModel getData() {
        return data;
    }

    @Override
    public void run() {
        this.progress.setValue(0);
        this.progress.setMessage("Retrieving data...");

        // processing simulation
        int compute = 10000000;
        for (int i = 0; i < compute; i++) {
            System.out.println(i);
            this.progress.setValue(i*100/compute);
        }


        this.progress.setValue(100);
        this.progress.setMessage("Completed!");
    }
}
