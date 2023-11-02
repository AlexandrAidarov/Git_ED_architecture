package LessonTenHW;

import LessonTenHW.exceptions.ProductAddException;
import LessonTenHW.exceptions.ProductServiceDeleteException;
import LessonTenHW.model.Product;
import LessonTenHW.model.UnitOfWork;
import LessonTenHW.model.dao.IProductDAO;
import LessonTenHW.model.dao.InMemoryProductDao;
import LessonTenHW.model.repository.IRepository;
import LessonTenHW.model.repository.ProductRepository;
import LessonTenHW.model.ProductService;

public class Main {
    public static void main(String[] args) throws ProductAddException, ProductServiceDeleteException {
        IProductDAO productDAO = new InMemoryProductDao();
        IRepository<Product> productRepository = new ProductRepository(productDAO);
        ProductService productService = new ProductService(productRepository);
        UnitOfWork unitOfWork = new UnitOfWork(productService);

        Product productOne = new Product(1, "HP 141w", 17000);
        Product productTwo = new Product(2, "HP 141a", 16000);

        //add two products
        unitOfWork.addProduct(productOne);
        unitOfWork.addProduct(productTwo);

        //print repository size
        System.out.println(productRepository.getAll().size());

        //revert all operations
        unitOfWork.revertAllOperations();

        //commit
        unitOfWork.commit();

        //print repository size
        System.out.println(productRepository.getAll().size());

        //add product again
        unitOfWork.addProduct(productOne);

        //commit
        unitOfWork.commit();

        //print repository size
        System.out.println(productRepository.getAll().size());
    }
}
