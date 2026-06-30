public interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Strumming the guitar");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano keys");
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Piano piano = new Piano();

        guitar.play();
        piano.play();
    }
}
