class Clidders {
        public final void flipper() { System.out.println("Flip a Clidder"); }
    }
    public class Clidlets extends Clidders {
        public void flipper() {
            System.out.println("Flip a Clidlet");
            super.flipper();
        }

        public static void main(String [] args) {
            new Clidlets().flipper();
        }
    }
