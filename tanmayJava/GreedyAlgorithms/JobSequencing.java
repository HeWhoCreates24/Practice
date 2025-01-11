import java.util.*;

public class JobSequencing{

    public static void main(String[] args) {
        
        // given
        int[][] jobs = {{4, 20, 'a'}, {1, 10, 'b'}, {1, 40, 'c'}, {1, 30, 'd'}};

        // sort greedily
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));

        // track time & do jobs
        int time = 0;
        ArrayList <Character> done = new ArrayList<>();

        for (int i = jobs.length - 1; i >= 0; i--){

            if (jobs[i][0] > time){

                done.add((char) jobs[i][2]);
                time++;

            }

        }

        System.out.println("Jobs did : " + done);

    }

}