package Services;

import Display.Login;

public class Principal {

    public static void main(String[] args) {
        System.out.println("     ██████╗     ██╗    ██╗  ██╗    ██╗    \n" +
"    ██╔═══██╗    ██║    ██║  ██║    ██║    \n" +
"    ██║   ██║    ██║    ███████║    ██║    \n" +
"    ██║   ██║    ██║    ██╔══██║    ██║    \n" +
"    ╚██████╔╝    ██║    ██║  ██║    ██║    \n" +
"     ╚═════╝     ╚═╝    ╚═╝  ╚═╝    ╚═╝    \n" +
"                                           \n" +
"");
        Login login = new Login();
        login.show();

    }
}
