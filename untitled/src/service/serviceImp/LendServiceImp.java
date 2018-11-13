package service.serviceImp;

import dao.LendDao;
import model.Lend;
import service.LendService;

import java.util.List;

public class LendServiceImp implements LendService {
    public LendDao getLendDao() {
        return lendDao;
    }

    public void setLendDao(LendDao lendDao) {
        this.lendDao = lendDao;
    }

    LendDao lendDao;
    public boolean borrow(Lend lend) {
        return lendDao.borrow(lend);
    }
    public boolean reBack(Lend lend) {
        return lendDao.reBack(lend);
    }
    public List findBorrowBook(String username, int pageNow, int pageSize) {
        return lendDao.findBorrowBook(username, pageNow, pageSize);
    }
    public int findBorrowBookSize(int pageNow, int pageSize) {
        return lendDao.findBorrowBookSize(pageNow, pageSize);
    }
}
