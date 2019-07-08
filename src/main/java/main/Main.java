package main;

import core.AdminManagement;
import core.CoreManagement;
import model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CoreManagement coreManagement = new CoreManagement();
        coreManagement.start();
    }
}
