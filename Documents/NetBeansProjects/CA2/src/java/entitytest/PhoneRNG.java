/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitytest;

import java.util.Random;

/**
 *
 * @author Kristian Nielsen
 */
public class PhoneRNG {

    public static void main(String[] args) {

        Random r = new Random();

        for (int i = 0; i < 35; i++) {
            String res = "";

            for (int j = 0; j < 8; j++) {
                res += r.nextInt(10);
            }

            System.out.println(res);
        }

    }
}
