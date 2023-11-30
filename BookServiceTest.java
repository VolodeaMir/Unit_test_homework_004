import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Test
    public void testGetBookById() {
        // Создаем мок-объект BookRepository
        BookRepository mockRepository = mock(BookRepository.class);

        // Создаем экземпляр BookService, передавая мок-объект в качестве зависимости
        BookService bookService = new BookService(mockRepository);

        // Задаем ожидаемое поведение мок-объекта
        when(mockRepository.getBookById(1)).thenReturn(new Book(1, "Mock Book"));

        // Вызываем метод, который мы тестируем
        Book result = bookService.getBookById(1);

        // Проверяем, что метод getBookById был вызван с аргументом 1
        verify(mockRepository).getBookById(1);

        // Проверяем, что результат метода соответствует ожидаемому
        assertEquals("Mock Book", result.getTitle());
    }
}
