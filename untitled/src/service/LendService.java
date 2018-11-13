package service;

import model.Lend;

import java.util.List;

public interface LendService {
    public boolean borrow(Lend lend);
    public boolean reBack(Lend lend);
    public List findBorrowBook(String username, int pageNow, int pageSize);
    public int findBorrowBookSize(int pageNow, int pageSize);

}
