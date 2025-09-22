public class Polynomial {
    private double[] c;

    public Polynomial() {
        this.c = new double[]{0.0};
    }

    public Polynomial(double[] cf) {
        if (cf == null || cf.length == 0) {
            this.c = new double[]{0.0};
        } else {
            this.c = new double[cf.length];
	    int len = cf.length;
	    this.c = new double[len];
            for (int i = 0; i < len; i++) {
                this.c[i] = cf[i];
            }
        }
    }

    public Polynomial add(Polynomial other) {
        int ml = Math.max(this.c.length, other.c.length);
        double[] res = new double[ml];

        for (int i = 0; i < ml; i++) {
            double a = (i < this.c.length) ? this.c[i] : 0.0;
            double b = (i < other.c.length) ? other.c[i] : 0.0;
            res[i] = a + b;
        }

        return new Polynomial(res);
    }

    public double evaluate(double x) {
        double sum = 0.0;
        for (int i = 0; i < c.length; i++) {
            sum += c[i] * Math.pow(x, i);
        }
        return sum;
    }

    public boolean hasRoot(double x) {
        double value = evaluate(x);
        double EPS = 1e-9;
        return Math.abs(value) < EPS;
    }
}