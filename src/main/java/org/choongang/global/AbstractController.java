package org.choongang.global;

import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractController implements Controller {

    // 공통적인 부분(공유 자원)으로 스캐너를 공유하기 위해 추상 메서드로 정의해놓음
    protected Scanner sc;

    public AbstractController() {
        sc = new Scanner(System.in);
    }

    /**
     * 상단 공통 출력 부분
     */
    public void common() {
        System.out.println("묵찌빠 게임 Ver1.0");
        System.out.println(Templates.getInstance().doubleLine());
    }

    /**
     * 입력 항목
     *  - 문자: q, exit, quit - 종료
     *  - 숫자: 메뉴 항목
     */
    public void prompt() {
        System.out.print("메뉴 선택: ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("종료 합니다.");
            System.exit(0); // 0 - 정상 종료, 1 - 비정상 종료
        }

        try {
            int m = Integer.parseInt(menu);
            change(m); // 메뉴 변경
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }

    /**
     * 입력과 검증을 함께 진행
     *
     * @param message : 항목 메세지
     * @param predicate : 판별식
     * @return
     */
    // 추상 클래스의 목적 : 설계, 공통 자원 기능 공유, 인터페이스의 목적 : 설계, 함수형 인터페이스 : 사용자 정의 기능, 열린 기능
    protected String promptWithValidation(String message, Predicate<String> predicate) {
        String str = null; // 판별식
        do {
            System.out.print(message);
            str = sc.nextLine();
        } while(!predicate.test(str));

        return str;
    }

    /**
     * 템플릿 메서드 패턴 : 특정 절차가 고정되어 있는 경우
     *
     */
    @Override
    public final void run() {
        common(); // 공통적으로 학생관리 프로그램 상단에 출력
        show(); // 각각 다른 기능을 넣기 위해 하위 인터페이스에서 구현하면 된다 -> 그래서 따로 정의해두지 않음
        prompt(); // 입력받는 부분
    }

    private void change(int menuNo) {
        MainMenu mainMenu = null;
        switch(menuNo) {
            case 1: mainMenu = MainMenu.JOIN; break; // 회원가입
            case 2: mainMenu = MainMenu.LOGIN; break; // 로그인
            case 3: mainMenu = MainMenu.GAME; break; // 게임하기
            default: mainMenu = MainMenu.MAIN; // 메인 메뉴
        }

        // 메뉴 컨트롤러 변경 처리 - Router
        MainRouter.getInstance().change(mainMenu);
    }
}