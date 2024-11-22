package org.algorithms.io.threading;

public class JavaVirtualThreads {
    public static void main(String[] args) throws InterruptedException {

        Thread.ofVirtual()
                .name("Aqib")
                .start(() -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Hi there");
                })
                .join();


//        var virtualThreads = new ArrayList<Thread>();
//
//        for(int i = 0; i < 10000; i++) {
//            virtualThreads.add(Thread.startVirtualThread(() -> {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("Hi there" );
//            }));
//        }
//
//        virtualThreads.forEach(thread -> {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        String data = "Aqib";
//        switch(data) {
//            case "Aqib", "aqib" -> System.out.println("Hi there");
//            default -> System.out.println("Bye there");
//        }
    }
}
