package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDER = "└ ₩ ┘";

    public static void printMainMenu() {
        System.out.println("\n## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("\n## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (Table table : tables) {
            printLine(BOTTOM_LINE, BOTTOM_LINE_ORDER, table);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println();
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printOrderHistory(Table orderTable) {
        System.out.println("\n## 주문 내역");
        System.out.println("메뉴 수량 금액");
        System.out.println(orderTable.orderMenuTotal());
    }

    public static void printTotalOrder(Table orderTable, int paymentType) {
        System.out.println("\n## 최종 결제할 금액");
        System.out.println(orderTable.orderPriceTotal());
    }

    public static void printTableNoOrder(int tableNumber) {
        System.out.println("\n## " + tableNumber +"번 테이블은 주문내역이 없습니다.");
        System.out.println("## 메인 화면으로 돌아갑니다.");
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printLine(final String line, final String line_order, Table table) {
        if(table.getOrderTF()) {
            System.out.print(line_order);
            return;
        }
        System.out.print(line);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
