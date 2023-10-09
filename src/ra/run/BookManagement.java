package ra.run;

import ra.bussiness.IBook;
import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    static List<Book> bookList = new ArrayList<Book>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách [15 điểm]\n" +
                    "2. Hiển thị thông tin các sách [15 điểm]\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần [15 điểm]\n" +
                    "4. Xóa sách theo mã sách [10 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi trạng thái của sách theo mã sách [10 điểm]\n" +
                    "7. Thoát [05 điểm]");
            System.out.println("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBook();
                    break;
                case 3:
                    sortInterest();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    changeStatus();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại từ 1 - 7...");
                    break;
            }
        }
    }

    public static void addBook() {
        System.out.println("Nhập số lượng sách cần thêm: ");
        int number = new Scanner(System.in).nextInt();
        for (int i = 0; i < number; i++) {
            Book book = new Book();
            System.out.println("Nhập tên sách thứ " + (i + 1) + " :");
            book.inputData();
            bookList.add(book);
        }
        System.out.println("Thêm thành công.");
    }

    public static void showBook() {
        boolean check = false;
        for (Book book : bookList) {
            if (book != null) {
                book.displayData();
            }
            check = true;
        }
        if (!check) {
            System.out.println("Rỗng.");
        }
    }

    public static void sortInterest() {
        Collections.sort(bookList, new Comparator<IBook>() {
            @Override
            public int compare(IBook book1, IBook book2) {
                return Float.compare(((Book) book2).getInterest(), ((Book) book1).getInterest());
            }
        });
        System.out.println("Danh sách đã được sắp xếp theo lợi nhuận giảm dần.");
        showBook();
    }

    public static void deleteBook() {
        System.out.println("Nhập id muốn xóa: ");
        int id = scanner.nextInt();
        boolean flag = false;
        for (Book book : bookList) {
            if (book.getBookId() == id) {
                bookList.remove(book);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không thấy id.");
        } else {
            System.out.println("Xóa thành công.");
        }
    }

    public static void searchBook() {
        System.out.println("Tìm tên sách: ");
        String nameBook = scanner.next();
        boolean flag = true;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(nameBook)) {
                book.displayData();
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Không thấy tên sách.");
        }
    }

    public static void changeStatus() {
        System.out.println("Nhập id muốn thay đổi trạng thái: ");
        int id = scanner.nextInt();
        boolean check = false;
        for (Book book : bookList) {
            if (book.getBookId() == id) {
                if (book.isBookStatus()) {
                    book.setBookStatus(false);
                    check = true;
                    break;
                } else {
                    book.setBookStatus(true);
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            System.out.println("Không thấy id muốn thay đổi.");
        } else {
            System.out.println("Thay đổi thành công");
        }
    }

    public static Book findById(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookId() == id) {
                return bookList.get(i);
            }
        }
        return null;
    }
}

