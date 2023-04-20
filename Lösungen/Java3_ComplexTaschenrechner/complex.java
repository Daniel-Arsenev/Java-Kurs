class complex {
    double re = 0;
    double im = 0;

    static complex add(complex z1, complex z2) {
        complex ret = new complex();
        ret.re = z1.re + z2.re;
        ret.im = z1.im + z2.im;

        return ret;
    }

    static complex sub(complex z1, complex z2) {
        complex ret = new complex();
        ret.re = z1.re - z2.re;
        ret.im = z1.im - z2.im;

        return ret;
    }

    static complex mul(complex z1, complex z2) {
        complex ret = new complex();
        ret.re = (z1.re * z2.re) - (z1.im * z2.im);
        ret.im = (z1.re * z2.im) + (z2.re * z1.im);

        return ret;
    }

    static complex conj(complex z1) {
        complex ret = new complex();
        ret.re = z1.re;
        ret.im = -z1.im;

        return ret;
    }

    static complex abs(complex z1) {
        complex ret = new complex();
        ret.re = Math.sqrt(z1.re * z1.re + z1.im * z1.im);
        ret.im = 0;

        return ret;
    }

    static complex div(complex z1, complex z2){
        complex top = complex.mul(z1, complex.conj(z2));
        complex scaler = complex.abs(z2);

        complex ret = new complex();
        ret.re = top.re / (scaler.re * scaler.re);
        ret.im = top.im / (scaler.re * scaler.re);

        return ret;



    }




}