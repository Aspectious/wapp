package dev.aspectious.wapp;

import ucar.ma2.*;
import ucar.nc2.*;
import ucar.nc2.write.Ncdump;

import java.io.IOException;


public class main {
    public static void main(String[] args) {
        try (NetcdfFile ncfile = NetcdfFiles.open("C:\\Users\\gdsie\\Downloads\\hrrr.t16z.wrfnatf18.grib2")) {
            Variable var = ncfile.findVariable("Reflectivity_height_above_ground");

            try {
                // sectionSpec is string specifying a range of data, eg ":,1:2,0:3"
                Array data = var.read("0:0,0:0,:,:").reduce();
                System.out.println(data.getSize() + ", " + data.get);
                String arrayStr = Ncdump.printArray(data, "test", null);
                //System.out.println(arrayStr);
            } catch (IOException | InvalidRangeException e) {
                System.err.println(e);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
