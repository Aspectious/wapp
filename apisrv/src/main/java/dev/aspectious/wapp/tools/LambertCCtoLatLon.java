package dev.aspectious.wapp.tools;


public class LambertCCtoLatLon {
    public static float[] transformLCCtoDat(float Lambert_x,float Lambert_y,float c_meridian, float zero_parallel, float one_parallel, float two_parallel, float earth_rad) {
       double n = Math.log(Math.cos(one_parallel) * (1/(Math.cos(two_parallel)))) / Math.log(Math.tan(0.25*Math.PI + 0.5 * two_parallel) * (1/Math.tan(0.25 * Math.PI + 0.25 * one_parallel)));
       double F = (Math.cos(one_parallel) * Math.pow(Math.tan(0.25 * Math.PI + 0.5 * one_parallel),n)) / n;
       double p = earth_rad * F * Math.pow(1/Math.tan(0.25 * Math.PI + 0.5 * zero_parallel),n);
       double p_0 = earth_rad * F * Math.pow(1/Math.tan(0.25 * Math.PI + 0.5 * zero_parallel),n);
        return new float[] {0.0f,0.0f};
    }
}
