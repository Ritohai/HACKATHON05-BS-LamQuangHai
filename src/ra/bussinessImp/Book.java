package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

import static ra.run.BookManagement.findById;

public class Book implements IBook {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sách: ");
        while (true) {
            int id = Integer.parseInt(scanner.nextLine());
            if (findById(id) != null) {
                System.out.println("Mã sách đã tồn tại mời nhập lại!");
            } else {
                this.bookId = id;
                break;
            }
        }
        System.out.println("Nhập tên sách: ");
        while (true) {
            String name = scanner.nextLine();
            if (name.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.bookName = name;
                break;
            }
        }
        System.out.println("Nhập tiêu đề: ");
        while (true) {
            String title = scanner.nextLine();
            if (title.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.title = title;
                break;
            }
        }
        System.out.println("Nhập số trang sách: ");
        while (true) {
            String nb = scanner.nextLine();
            if (nb.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.numberOfPages = Integer.parseInt(nb);
                break;
            }
        }
        System.out.println("Nhập giá nhập sách: ");
        while (true) {
            String imp = scanner.nextLine();
            if (imp.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.importPrice = Float.parseFloat(imp);
                break;
            }
        }
        System.out.println("Nhập giá bán(Phần trăm giá bán cao hơn so với giá nhập): ");
        this.exportPrice =  Float.parseFloat(scanner.nextLine()) / 100 * importPrice + importPrice;
        this.interest = exportPrice - importPrice;
        System.out.println("Trạng thái: ");
        while (true) {
            String status = scanner.nextLine().toLowerCase();
            if (status.trim().equals("true") || status.trim().equals("false")) {
                this.bookStatus = Boolean.parseBoolean(status);
                break;
            }else {
                System.out.println("Không hợp lệ mời nhập lại!");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Id: " + bookId + "| Tên sách: " + bookName);
        System.out.println("Tiêu đề: " + title + "| Số trang sách: " + numberOfPages);
        System.out.println("Giá nhập: " + importPrice + "| Giá bán: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest + "| Trạng thái: " + (bookStatus ? "Còn hàng" : "Hết hàng"));
    }
}
