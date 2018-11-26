package traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /* This class realizes traffic light.
     * Enter number of minutes in console and you will get the current color.
     */
public class TrafficLight {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int in = Integer.parseInt(reader.readLine());
            System.out.println(getTrafficLightColor(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTrafficLightColor(int time) {
        if (time >= 0) {
            if (time % 10 >= 0 && time % 10 < 2) {
                return "Red";
            } else if (time % 10 >= 2 && time % 10 < 5) {
                return "Yellow";
            } else if (time % 10 >= 5 && time % 10 < 10) {
                return "Green";
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

}