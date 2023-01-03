package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList safetyList = new SafetyList();

        Thread thread1 = getThread(safetyList);
        Thread thread2 = getThread(safetyList);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException error) {
            error.printStackTrace();
        }

        System.out.println("Size: " + safetyList.getSize());
        // END
    }

    private static Thread getThread(SafetyList safetyList) {
        return new Thread(safetyList.toString());
    }
}

