package org.algorithms.io.threading;

class Police {
    private boolean moneySent = false;

    public void giveRansom(Criminal criminal) throws InterruptedException {
        while(!criminal.isHostageReleased()) {
            System.out.println("Police: waiting for criminal to release hostage");
            Thread.sleep(1000);
        }
        System.out.println("Police: sending ransom as criminal released hostage");
        moneySent = true;
    }

    public boolean isMoneySent() {
        return moneySent;
    }

}

class Criminal {
    private boolean hostageRelease = false;

    public void releaseHostage(Police police) throws InterruptedException {
        while(!police.isMoneySent()) {
            System.out.println("Criminal: waiting for police to send money");
            Thread.sleep(1000);
        }
        System.out.println("Criminal: money received, releasing hostage.");
        hostageRelease = true;
    }

    public boolean isHostageReleased() {
        return hostageRelease;
    }
}

public class LiveLock {

    public static void main(String[] args) {
        var criminal = new Criminal();
        var police = new Police();

        // live lock problem
        var t1 = new Thread(() -> {
            try {
                criminal.releaseHostage(police);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        var t2 = new Thread(() -> {
            try {
                police.giveRansom(criminal);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }
}
