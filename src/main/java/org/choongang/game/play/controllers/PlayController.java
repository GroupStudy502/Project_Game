package org.choongang.game.play.controllers;


import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.game.GameTpl;
import org.choongang.template.game.PlayTpl;

public class PlayController extends AbstractController {

    private int num;

    //1~3 난수 만드는 기능 메서드
    public int random() {  //랜덤 int num을 리턴하는 메서드
        return (int)(Math.random()*3)+1;  //Math.random() - 0~1 미만 난수 발생
    }

    //가위바위보 비교하는 기능
    public void pare(int su) {
        PlayTpl v = new PlayTpl();

        num = random();
        //su는 플레이어가 입력한 숫자
        if(su==1) {  // 플레이어 : 바위 선택
            switch(num) {  //컴퓨터가 랜덤으로 고른 수
                case 1 : System.out.println("컴퓨터 : 바위");
                    System.out.println("- 비겼습니다. 공격자 다시 정하기! -");v.gameStart();return;

                case 2 : System.out.println("컴퓨터 : 보");
                    System.out.println("- 졌습니다. 공격자 : 컴퓨터 -");v.lose();return;

                case 3 : System.out.println("컴퓨터 : 가위");
                    System.out.println("- 이겼습니다. 공격자 : 플레이어 -");v.win();return;
            }
        }

        if(su==2) {  //플레이어 : 가위 선택
            switch(num) {
                case 1 : System.out.println("컴퓨터 : 가위");
                    System.out.println("- 비겼습니다. 공격자 다시 정하기! -");v.gameStart();return;

                case 2 : System.out.println("컴퓨터 : 바위");
                    System.out.println("- 졌습니다. 공격자 : 컴퓨터 -");v.lose();return;

                case 3 : System.out.println("컴퓨터 : 보");
                    System.out.println("- 이겼습니다. 공격자 : 플레이어 -");v.win();return;
            }
        }

        if(su==3) {  //플레이어 : 보 선택
            switch(num) {
                case 1 : System.out.println("컴퓨터 : 보");
                    System.out.println("- 비겼습니다. 공격자 다시 정하기! -");v.gameStart();return;

                case 2 : System.out.println("컴퓨터 : 가위");
                    System.out.println("- 졌습니다. 공격자 : 컴퓨터 -");v.lose();return;

                case 3 : System.out.println("컴퓨터 : 바위");
                    System.out.println("- 이겼습니다. 공격자 : 플레이어 -");v.win();return;
            }
        }
    }

    //가위바위보 이겼을 때, 플레이어가 공격자
    public void winpare(int su) {
        PlayTpl v = new PlayTpl();

        num = random();

        if(su==1) {  //플레이어 : 묵 선택
            switch(num) {
                case 1 : System.out.println("컴퓨터 : 묵");
                    System.out.println("----- 플레이어 승리! -----");
                    System.out.println("=========== GAME OVER ==========");return;//다시 mainMenu로 돌아감

                case 2 : System.out.println("컴퓨터 : 찌");v.win();return;//플레이어가 다시 공격자

                case 3 : System.out.println("컴퓨터 : 빠");v.lose();return;//컴퓨터가 다시 공격자
            }
        }

        if(su==2) {  //플레이어 : 찌 선택
            switch(num) {
                case 1 : System.out.println("컴퓨터 : 묵");v.lose();return;

                case 2 : System.out.println("컴퓨터 : 찌");
                    System.out.println("----- 플레이어 승리! -----");
                    System.out.println("=========== GAME OVER ==========");return;

                case 3 : System.out.println("컴퓨터 : 빠");v.win();return;
            }
        }

        if(su==3) {  //플레이어 : 빠 선택
            switch(num) {
                case 1 : System.out.println("컴퓨터 : 묵");v.win();return;

                case 2 : System.out.println("컴퓨터 : 찌");v.lose();return;

                case 3 : System.out.println("컴퓨터 : 빠");
                    System.out.println("----- 플레이어 승리! -----");
                    System.out.println("=========== GAME OVER ==========");return;
            }
        }
    }

    //가위바위보 졌을 때, 컴퓨터가 공격자
    public void losepare(int su) {
        PlayTpl v = new PlayTpl();

        num = random();

        if(su==1) {  //플레이어 : 묵 선택
            switch(num) {
                case 1 : System.out.println("컴퓨터 : 묵");
                    System.out.println("----- 플레이어 패배! -----");
                    System.out.println("=========== GAME OVER ==========");return;

                case 2 : System.out.println("컴퓨터 : 찌");v.win();return;

                case 3 : System.out.println("컴퓨터 : 빠");v.lose();return;
            }
        }

        if(su==2) {  //플레이어 : 찌 선택
            switch(num) {
                case 1 : System.out.println("컴퓨터 : 묵");v.lose();return;

                case 2 : System.out.println("컴퓨터 : 찌");
                    System.out.println("----- 플레이어 패배! -----");
                    System.out.println("=========== GAME OVER ==========");return;

                case 3 : System.out.println("컴퓨터 : 빠");v.win();return;
            }
        }

        if(su==3) {  //플레이어 : 빠 선택
            switch (num) {
                case 1 : System.out.println("컴퓨터 : 묵");v.win();return;

                case 2 : System.out.println("컴퓨터 : 찌");v.lose();return;

                case 3 : System.out.println("컴퓨터 : 빠");
                    System.out.println("----- 플레이어 패배! -----");
                    System.out.println("=========== GAME OVER ==========");return;
            }
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void prompt() {
        PlayTpl mv = new PlayTpl();

        try {
            mv.mainMenu();
        } catch (Exception e) {
            MainRouter.getInstance().change(MainMenu.GAME);
        }
    }
}
