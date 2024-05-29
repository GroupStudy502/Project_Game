package org.choongang.template.game;

import org.choongang.game.controllers.GameController;
import org.choongang.global.Controller;
import org.choongang.template.Template;
import org.choongang.game.play.controllers.PlayController;

import java.util.Objects;
import java.util.Scanner;


public class PlayTpl implements Template {

    PlayController ct = new PlayController(); //컨트롤러로 return 해야 하니까 객체 선언함


    public void mainMenu() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n" + "\n" + "        < 묵찌빠 게임 >        " + "\n");

            System.out.println("========== GAME START ==========");
            System.out.println("1.게임 시작  2.게임 종료");
            System.out.print("입력 : ");
            int su = sc.nextInt();

            switch (su) {
                case 1 : gameStart();break;
                case 2 : System.out.println("        < 게임 종료 >        ");return;
            }
        } while (true);
    }

    //공격자 선정 가위바위보 시작
    public void gameStart() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n" + "----- 공격자 정하기! 가위바위보 -----");
            System.out.println("1.바위 2.가위 3.보");
            System.out.print("입력 : ");
            int num=sc.nextInt();

            switch(num){
                case 1 : System.out.println("\n" + "플레이어 : 바위");ct.pare(1);return;  //비교하는 controller에 pare로 감
                case 2 : System.out.println("\n" + "플레이어 : 가위");ct.pare(2);return;
                case 3 : System.out.println("\n" + "플레이어 : 보");ct.pare(3);return;
            }
        } while (true);
    }

    //가위바위보 이겼으니까 플레이어가 공격자 -> 묵찌빠 시작
    public void win() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n" + "=======  묵 찌 빠!  =======");
            System.out.println("    < 공격자 : 플레이어 >    " + "\n");

            process(sc, "WIN");

        } while (true);
    }

    //가위바위보 졌으니까 컴퓨터가 공격자 -> 묵찌빠 시작
    public void lose() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n" + "=======  묵 찌 빠!  =======");
            System.out.println("    < 공격자 : 컴퓨터 >    " + "\n");

            process(sc, "LOSE");

        } while (true);
    }

    public void process(Scanner sc, String mode) {
        mode = Objects.requireNonNullElse(mode, "WIN");

        System.out.println("\n" + "1.묵 2.찌 3.빠");
        System.out.print("입력 : ");

        int num = sc.nextInt();

        if (mode.equals("WIN")) {
            switch (num) {
                case 1:
                    ct.winpare(1);
                    return;
                case 2:
                    ct.winpare(2);
                    return;
                case 3:
                    ct.winpare(3);
                    return;
            }


        } else {
            switch (num) {
                case 1:
                    ct.losepare(1);
                    return;

                case 2:
                    ct.losepare(2);
                    return;

                case 3:
                    ct.losepare(3);
                    return;
            }
        }
    }

    @Override
    public String getTpl() {
        return "";
    }
}













