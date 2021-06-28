-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 28, 2021 lúc 03:55 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookstore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `id` bigint(20) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `information` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

CREATE TABLE `banner` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `banner`
--

INSERT INTO `banner` (`id`, `name`, `url`) VALUES
(1, '1', 'web/CDweb/banner/8da743d575aecda9c96e190035d32f9e.jpg'),
(2, '2', 'web/CDweb/banner/93f7db9464f68d979696a20a58d80be4.png'),
(3, '3', 'web/CDweb/banner/muonkiepnhansinh_resize_920x420.jpg'),
(4, '4', 'web/CDweb/banner/TGDQ920x420.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `description` text COLLATE utf8_bin NOT NULL,
  `discount` float DEFAULT 0,
  `hot_book` bit(1) DEFAULT b'0',
  `new_book` bit(1) DEFAULT b'0',
  `page` bigint(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `publisher` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `short_description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `active`, `description`, `discount`, `hot_book`, `new_book`, `page`, `price`, `publisher`, `quantity`, `short_description`, `title`, `author_id`, `category_id`) VALUES
(16, b'1', 'Một lá thư thách đấu được gửi tới Kudo Shinichi - cậu thám tử học trò nổi tiếng với khả năng phá những vụ án phức tạp! Hung thủ viết: “Ta sẽ bắt cóc học sinh trong chuyến dã ngoại cuối năm của Trường trung học Teitan”. Cuộc chiến sinh tử giữa hung thủ và Shinichi đã bắt đầu!! ', 20, b'1', b'1', 221, 22000, 'NXB Kim đồng', 26, NULL, 'THÁM TỬ LỪNG DANH CONAN - LÁ THƯ THÁCH ĐẤU GỬI KUDO SHINICHI - (CÂU CHUYỆN TRƯỚC KHI CHIA TAY) (TÁI BẢN 2019)', NULL, 8),
(15, b'1', 'Bộ sách là phiên bản tập hợp đầy đủ nhất các truyện ngắn Doraemon, trong đó đã bao gồm những truyện ngắn quen thuộc trong bộ 45 tập cùng những sáng tác chưa từng ra mắt của tác giả Fujiko F Fujio được đăng rải rác trên các tạp chí dành cho lứa tuổi Nhi Đồng tại Nhật Bản.', 0, b'1', b'0', 255, 70000, 'NXB Kim đồng', 16, NULL, 'FUJIKO F FUJIO ĐẠI TUYỂN TẬP - DORAEMON TRUYỆN NGẮN - TẬP 11', NULL, 8),
(13, b'1', 'Những Mảng Màu Du Lịch Việt Nam', 10, b'0', b'1', 233, 40000, 'NXB Kim đồng', 6, NULL, 'Những Mảng Màu Du Lịch Việt Nam', NULL, 1),
(14, b'1', 'Bộ tranh truyện “Doraemon” có rất nhiều bí mật như bí mật về các nhân vật, bí mật về các bảo bối... Nội dung truyện chắc chắn đã giúp các bạn đi từ bí mật này đến bí mật khác, nhưng bạn còn có thể thâm nhập vào thế giới Doraemon sâu hơn nữa khi đọc phần “Giới thiệu nhân vật” và “Kho bảo bối bí mật”. Sở trường của Nobita là gì? Những bảo bối nào đã xuất hiện trong phim hoạt hình Doraemon?... Câu trả lời nằm trong bộ sách này, chúng ta cùng khám phá nhé!', 15, b'1', b'0', 122, 30000, 'NXB Kim đồng', 13, NULL, 'DORAEMON TUYỂN TẬP TRANH TRUYỆN MÀU KĨ THUẬT SỐ - TẬP 2 (TÁI BẢN 2018)', NULL, 8),
(12, b'1', 'Bộ sách gồm 5 cuốn chứa các bài tập hỏi đáp bằng hình ảnh sinh động, đơn giản, ngắn gọn, dễ hiểu giúp rèn luyện trí thông minh và các hoạt động vui chơi kích thích trí não với các chủ đề dành cho trẻ 7 tuổi', 0, b'1', b'0', 46, 30000, 'NXB Kim đồng', 30, NULL, 'Phát Triển Trí Thông Minh: Dành Cho Trẻ Từ 4 Tuổi', NULL, 1),
(11, b'1', 'Bộ sách gồm 5 cuốn chứa các bài tập hỏi đáp bằng hình ảnh sinh động, đơn giản, ngắn gọn, dễ hiểu giúp rèn luyện trí thông minh và các hoạt động vui chơi kích thích trí não với các chủ đề dành cho trẻ 7 tuổi.', 5, b'1', b'0', 46, 30000, 'NXB Kim đồng', 24, NULL, 'Phát Triển Trí Thông Minh: Dành Cho Trẻ Từ 5 Tuổi', NULL, 1),
(10, b'1', 'Bộ sách gồm 5 cuốn chứa các bài tập hỏi đáp bằng hình ảnh sinh động, đơn giản, ngắn gọn, dễ hiểu giúp rèn luyện trí thông minh và các hoạt động vui chơi kích thích trí não với các chủ đề dành cho trẻ 7 tuổi.', 0, b'1', b'1', 47, 30000, 'NXB Kim đồng', 21, NULL, 'Phát Triển Trí Thông Minh: Dành Cho Trẻ Từ 6 Tuổi', NULL, 1),
(9, b'1', 'Truyện cổ tích Anđécxen từ lâu đã quen thuộc với các bạn nhỏ trên khắp thế giới. Những câu chuyện cổ gợi mở trí tưởng tượng, sự hiểu biết của các em về thế giới xung quanh. Hơn thế nữa, truyện cổ tích Anđécxen giáo dục các em lòng yêu thương, biết ơn và kính trọng đối với ông bà, cha mẹ… Ngay cả người lớn, khi đọc cũng cảm nhận được những điều thú vị và bổ ích qua các câu chuyện nhỏ đáng yêu.', 0, b'0', b'1', 89, 57000, 'NXB Văn học', 11, NULL, 'Truyện cổ Andecxen', NULL, 3),
(8, b'1', '“Cuốn sách này thực sự rất hay, nó vừa giúp tôi được giải trí sau những giờ làm việc căng thẳng vừa đem đến cho tôi những bài học quý giá về sự tự tin, lòng dũng cảm và có niềm tin vào cuộc sống. Tôi không thể đặt cuốn sách xuống cho đến khi đọc xong, nội dung của cuốn sách hấp dẫn hơn những gì tôi vẫn nghĩ, nó thực sự là một cuốn sách tuyệt vời\" - Kendda', 0, b'1', b'0', 88, 33000, 'NXB Văn học', 10, NULL, 'Rump - Cậu bé xe rơm thành vàng', NULL, 3),
(7, b'1', '“Nếu bạn muốn lũ trẻ nhà bạn thông minh, hãy kể cho chúng nghe truyện cổ tích. Nếu bạn muốn chúng thông minh hơn nữa, hãy kể nhiều truyện cổ tích hơn.” – Albert Einstein', 0, b'1', b'1', 100, 50000, 'NXB Văn học', 9, NULL, 'Truyện cổ tích Việt Nam hay nhất (Tập 1)', NULL, 3),
(6, b'1', 'Khu vườn ngôn từ kể về một tình yêu còn xa xưa hơn cả tình yêu. Khái niệm tình yêu trong tiếng Nhật hiện đại là luyến hoặc ái, nhưng vào thời xưa nó được viết là cô bi, nghĩa là nỗi buồn một mình. Shinkai Makoto đã cấu tứ Khu vườn ngôn từ theo ý nghĩa cổ điển này, miêu tả tình yêu theo khái niệm ban sơ của nó, tức là cô bi - nỗi buồn khi một mình thương nhớ một người. ', 20, b'1', b'1', 200, 90000, 'NXB Văn học', 15, NULL, 'Khu Vườn Ngôn Từ', NULL, 6),
(5, b'1', 'Bạch Lăng Lăng, nữ sinh khoa Điện khí, trẻ trung, xinh đẹp và rất tự hào khi quen được một người bạn lý tưởng qua mạng, chàng du học sinh của một trường nổi tiếng của Mỹ, người mang biệt danh “nhà khoa học”: Mãi Mãi Là Bao Xa. Qua những cuộc chuyện trò trên QQ, Lăng Lăng đã gắn bó với chàng trai đó lúc nào cô cũng không hay, cảm xúc lớn dần, sự chia sẻ lớn dần và đến một ngày cô phát hiện ra mình đã yêu người con trai “tài giỏi” và không một chút khuyết điểm ấy. Nhưng sự tỉnh táo giúp cô ý thức được rằng, thế giới mạng chỉ là ảo, họ ở cách nhau cả một đại dương mênh mông, anh lại quá xuất sắc và ưu tú, mối quan hệ của họ sẽ không có kết quả gì. Nhất là khi anh thông báo, nếu anh tiếp tục sự nghiệp nghiên cứu lần này, rất có thể anh phải định cư bên Mỹ, mãi mãi không trở về.', 0, b'0', b'0', 220, 90000, 'NXB Văn học', 30, NULL, 'Mãi Mãi Là Bao Xa', NULL, 6),
(4, b'1', 'Hồ Ly Biết Yêu Nàng là hồ ly, vốn thuộc về ma giới - nơi quanh năm suốt tháng chìm trong mây mù, dù thần tiên cũng không thể đi vào; chàng là thần tiên, là mặt trời chiếu sáng cho muôn loài, được thế gian muôn đời sùng bái.Luật trời viết rằng, thần tiên và yêu ma không thể ở bên nhau. Nhưng trái tim nàng mách bảo rằng, ngoài chàng ra, nàng không muốn ở bên bất cứ một người nào khác.Số mệnh đã định, rằng nàng sinh ra để làm chủ nhân của ma giới, nhưng nàng chỉ muốn làm chủ nhân của trái tim chàng.…Liệu có một ngày, vầng dương kia thôi chiếu sáng, để trở thành một phu quân bình thường của hồ ly? Liệu có một ngày, hồ ly kia không còn chống lại số mệnh nữa, chấp nhận làm phu nhân của ma vương? Liệu có một ngày, ma giới kia không còn u ám nữa, để ánh dương chiếu tỏ?Bất kể thế nào, hồ ly cũng tin rằng, dù nàng không còn gì cả, ánh dương vẫn chỉ thuộc về mình nàng mà thôi. Có hồ ly, ánh dương kia càng thêm rực rỡ. Có vầng dương, hồ ly… lần đầu biết yêu…', 0, b'1', b'1', 200, 80000, 'NXB Văn học', 19, NULL, 'Hồ ly biết yêu', NULL, 6),
(3, b'1', 'Vật Lí 9 (Song Ngữ Việt - Anh) Sách giáo khoa Vật lý song ngữ Việt - Anh - Sách giáo khoa song ngữ Việt - Anh Vật lý - Sách giáo khoa Lý song ngữ Việt - Anh - Sách giáo khoa song ngữ Vật lý - Sách giáo khoa song ngữ lý Nhà xuất bản Giáo dục Việt Nam', 0, b'0', b'0', 125, 20000, 'NXB Giao dục Việt Nam', 20, NULL, 'Vật lí 9', NULL, 2),
(1, b'1', 'Bộ sách gồm 5 cuốn chứa các bài tập hỏi đáp bằng hình ảnh sinh động, đơn giản, ngắn gọn, dễ hiểu giúp rèn luyện trí thông minh và các hoạt động vui chơi kích thích trí não với các chủ đề dành cho trẻ 7 tuổi.', 0, b'0', b'0', 100, 120000, 'NXB Kim đồng', 24, NULL, 'Lên Núi Cao Thử Tài Tinh Mắt', NULL, 1),
(2, b'1', 'Để học tốt chương trình lớp 6, ngoài các kiến thức trong sách giáo khoa, các em học sinh cần luyện tập thêm các bài tập trong các sách bài tập. Bộ sách cung cấp đủ các bài tập cần thiết bám sát chương trình giáo khoa lớp 6, là tài liệu bổ ích giúp các em học tập tốt và tự tin ghi điểm trong các kì thi.', 45, b'0', b'0', 250, 250000, 'NXB Giao dục Việt Nam', 10, NULL, 'Bộ sách lớp 6', NULL, 2),
(34, b'1', 'Cảm giác của những ngày sau chia tay cũng giống như khi bạn đứng ở một góc tối nhìn ra thành phố rực rỡ ánh đèn vậy. Vô cùng lạc lõng, vô cùng đơn độc. Sau chia tay, là những ngày nhớ người ta đến điên cuồng. Vì còn thương nhiều lắm. Nhưng từ nay sẽ không được ở bên nữa. Chỉ nhiêu đó thôi đủ khiến cả người buồn bã, không muốn làm, không làm nổi việc gì.', 35, b'1', b'0', 267, 76000, 'NXB Thanh niên', 10, NULL, 'Nghe Nói Anh Muốn Chia Tay', NULL, 6),
(35, b'1', 'Giá như cuộc đời này, chỉ cần em thương anh là đủ? Vậy thì thương bao nhiêu em cũng có thể thương được, đem hết cả ruột gan tâm can cho anh em cũng chẳng nề chi. Giá như cứ thả lòng đắm say một người, đừng bao giờ là kẻ đến muộn hay đến sau trong một mối tình đã chật chỗ từ lâu, chẳng phải ngửa tay xin một chút tình rơi sót buồn bã đến vậy?', 0, b'0', b'0', 247, 88000, 'NXB Hà Nội', 7, NULL, 'Đơn Phương - Anh Không Thương Em', NULL, 6),
(36, b'1', 'Án mạng trên sông Nile là một trong những tác phẩm nổi tiếng của nữ nhà văn Agatha Christie. Tác phẩm đã được chuyển thể thành phim điện ảnh, kịch và nhận được sự yêu thích, đón nhận nồng nhiệt của các độc giả khắp nơi trên thế giới. Bằng lối kể chuyện đầy hấp dẫn, hồi hộp trong những câu chữ, \"Án mạng trên sông Nile\" khiến cho độc giả đi từ bất ngờ này đến bất ngờ khác. Nội dung cuốn tiểu thuyết xoay quanh vụ án mạng nghiêm trọng diễn ra trên con tàu du lịch trên sông Nile, nơi mà thám tử Hercule Poirot đang nghỉ dưỡng.\r\n\r\n\r\n\r\nNhững cuộc truy tìm hung thủ, những khám phá từ những chi tiết nhỏ còn sót lại sẽ khiến cho chúng ta bị lôi cuốn theo từng tình tiết, từng câu chữ của truyện. Hơn gì hết, một cái kết bất ngờ luôn là điểm nhấn ghi lại dấu ấn trong lòng độc giả nhiều hơn. Và cuốn tiểu thuyết \"Án mạng trên sông Nile\" đã làm được điều đó. Quả là một cuốn tiểu thuyết trinh thám rất đáng xem.', 0, b'0', b'1', 334, 98000, 'NXB Trẻ', 15, NULL, 'Án mạng trên sông Nile', NULL, 7),
(37, b'1', 'Mật mã Davinci là một trong số những tác phẩm nổi tiếng của nhà văn người Mỹ: Dan Brown. Trong những năm trở lại đây, cái tên Dan Brown được biết đến như một nhà văn chuyên viết tiểu thuyết trinh thám li kì, độc đáo. Các tác phẩm của ông bên cạnh những tình tiết khám phá, truy tìm hung thủ thì còn cung cấp một lượng kiến thức đồ sộ về kiến trúc, văn hóa của các nước phương Tây đến với bạn đọc.\r\n\r\n\r\n\r\nCâu chuyện nói về hành trình của Giáo sư trường đại học Harvard Robert Langdon và chuyên gia giải mật mã Sophie Neuveu trong hành trình đi tìm bí ẩn đằng sau cái chết của Jacques Saunière - ông của Sophie. Dan Brown sẽ dẫn dắt chúng ta khám phá từ bất ngờ này đến bất ngờ khác qua các biến chuyển của mạch truyện. Nếu yêu thích các tác phẩm tiểu thuyết trinh thám, đừng bỏ qua tác phẩm bạn nhé. Bên cạnh có giá trị giải trí, cuốn tiểu thuyết này còn cung cấp cho bạn những kiến thức mới lạ và độc đáo.', 0, b'1', b'0', 286, 111000, 'NXB Văn hóa-Thông Tin', 9, NULL, 'Mật mã Davinci', NULL, 7),
(38, b'1', 'Thêm một tác phẩm tiểu thuyết trinh thám của nhà văn Dan Brown, Hỏa ngục được độc giả biết đến là cuốn tiểu thuyết bìa cứng bán chạy nhất trên danh sách New York Times Best Seller. Được xuất bản vào năm 2013, \"Hỏa ngục\" đã thực sự tạo dấu ấn sâu sắc bởi những suy nghĩ, vấn đề gợi ra từ tác phẩm: hiện trạng bùng nổ dân số trên thế giới. Song song đó, tác phẩm còn khẳng định được giá trị của mình bằng giọng văn lôi cuốn cũng như tình tiết truyện độc đáo.\r\n\r\n\r\n\r\nTác phẩm ngay từ khi xuất bản đã thu về doanh thu rất cao, cũng như được dịch ra nhiều thứ tiếng khác nhau trên thế giới. Đồng thời, tác phẩm cũng được chuyển thể thành phim và dự kiến chiếu vào tháng 4 năm 2016.\r\n\r\n', 0, b'1', b'0', 308, 120000, 'NXB Văn học', 5, NULL, 'Hỏa ngục', NULL, 7),
(39, b'1', '\r\n\r\nMáu lạnh là một cuốn tiểu thuyết trinh thám nổi tiếng viết về tâm lí học tội phạm rất đáng đọc. Những vụ án nghiêm trọng, những cái chết bi thương, đau đớn đều được xuống tay bởi những tên sát thủ tàn nhẫn, máu lạnh. Đọc qua từng vụ án, chúng ta thầm nghĩ liệu rằng những tên sát nhân ấy có phải là con người? Trong đầu bọn chúng đang suy tính những điều gì ghê rợn hơn thế nữa?\r\n\r\n\r\n\r\nViệc hình thành nên tội ác là cả một quá trình phức tạp của tâm lí. Hơn gì hết, tác phẩm đã khắc họa sâu sắc được những ngóc ngách phức tạp trong tâm lí tội phạm đó. Không những đem đến giây phút thư giãn với những câu chuyện trinh thám, tác phẩm còn là một trải nghiệm thú vị để chúng ta khám phá những bí ẩn đằng sau những tên tội phạm, sát nhân độc ác đó.\r\n\r\n', 20, b'0', b'1', 277, 125000, 'NXB Hà Nội', 22, NULL, 'Máu lạnh', NULL, 7),
(40, b'1', 'Sự im lặng của bầy cừu là một tác phẩm trinh thám xen lẫn yếu tối kinh dị nổi tiếng do tác giả Thomas Harris chắp bút. Tác phẩm cũng đã được chuyển thể thành phim với cùng tựa đề vào năm 1991, gây được tiếng vang lớn trong giới điện ảnh, cũng như đưa tác phẩm đến gần với bạn đọc hơn.\r\n\r\n\r\n\r\nBằng việc miêu tả tâm lí nhân vật hết sức tinh tế, cùng với những tình tiết truyện gay cấn, hồi hộp, tác phẩm đã để lại trong lòng bạn đọc những ấn tượng sâu sắc, khó phai và ám ảnh về hình ảnh của Hannibal Lecter - một kẻ ăn thịt người. Nếu bạn là người yêu thích tiểu thuyết trinh thám, đừng bỏ qua quyển tiểu thuyết nổi tiếng này nhé, Chắc chắn truyện trinh thám này sẽ tạo được dấu ấn cực kì khó phai với bạn.\r\n\r\n', 0, b'1', b'0', 221, 95000, 'NXB Hội nhà văn', 11, NULL, 'Sự im lặng của bầy cừu', NULL, 7),
(41, b'1', 'Với “Sát nhân mạng”, tiểu thuyết gia trinh thám nổi tiếng Jeffery Deaver đã khai thác một chủ đề mới gắn liền với thế giới hiện đại, về hacker và thế giới máy tính. Câu chuyện xuất phát từ ý niệm rất giản đơn: Sẽ đáng sợ thế nào nếu ai đó có thể biết mọi điều về cuộc sống của chúng ta - những điều chúng ta nghĩ là bí mật của riêng mình, và sử dụng chính những thông tin ấy để sát hại chúng ta. Nỗi cô đơn và sự ruồng bỏ suốt thuở thiếu thời đã biến Phate thành một hacker máu lạnh\r\n\r\n.\r\n\r\nMỗi trang sách là một cuộc rượt đuổi đầy cam go trên thế giới máy tính và cả ngoài đời thực. Cứ mỗi lần tưởng chừng đã tóm được tay sát nhân hàng loạt, thì hắn lại vụt khỏi tầm tay. Những tình huống bất ngờ đan xen trên từng trang sách khi không biết ai là gián điệp tiếp tay cho kẻ giết người, và nhân dạng thực sự của tên sát nhân Phate ra sao, … người tốt và kẻ xấu đều muốn giành chiến thắng trong trò chơi chiến thuật máy tính ngoài đời thực.\r\n\r\n', 8, b'0', b'0', 305, 75000, 'NXB Lao động', 10, NULL, 'Sát nhân mạng', NULL, 7),
(42, b'1', 'Bộ sách vô cùng thú vị mang lại nhiều thông tin bổ ích về Thế giới động vật: Động vật thời Tiền sử, động vật hoang dã, sâu bọ, côn trùng... và cách thích nghi với môi trường của chúng.', 0, b'0', b'1', 105, 35000, 'NXB Kim đồng', 9, NULL, 'Khủng Long Có Đẻ Trứng Không? - Hỏi Đáp Về Bò Sát Thời Tiền Sử', NULL, 1),
(43, b'1', 'Tuyển tập 150 bài văn mẫu hay giúp học sinh tham khảo nhằm nâng cao kỹ năng văn học.', 0, b'0', b'0', 70, 40000, 'NXB Đà Nẵng', 15, NULL, '150 bài văn hay lớp 12', NULL, 2),
(44, b'1', 'Mỗi dân tộc có một kho thần thoại riêng được ghi lại bằng văn tự hay bằng phương thức truyền miệng. Cuốn sách tuyển chọn truyện thần thoại của các dân tộc khác nhau trên khắp thế giới, mang đến những khám phá thú vị về đời sống văn hóa dân gian của các tộc người.', 0, b'1', b'0', 70, 50000, 'NXB Văn học', 30, NULL, 'Thần Thoại Thế Giới Chọn Lọc', NULL, 3),
(45, b'1', 'Cuốn sách là một cẩm nang hướng dẫn chi tiết về việc sử dụng trí tuệ Enneagram cho sự phát triển của tâm linh và tâm lý. Biểu tượng cổ xưa của Enneagram đã trở thành một trong những hệ thống phổ biến nhất hiện nay để tự nghiên cứu, khám phá mỗi người dựa trên chín loại tính cách riêng biệt. Hai trong số các nhà nghiên cứu về Enneagram hàng đầu trên thế giới là Don Richard Riso và Russ Hudson đã liên tục nhắc tới và giảng dạy về Enneagram như một công cụ để chuyển đổi và phát triển cá nhân. Dù nền tảng tinh thần của bạn là gì, Enneagram sẽ đưa ra những lời khuyên, biện pháp tích cực giúp bạn vượt qua mọi rào cản sâu thẳm nơi tâm hồn, nhận ra những sức mạnh độc đáo và những hướng đi đúng đắn nhất trong cuộc sống. ', 0, b'1', b'0', 99, 50000, 'NXB Thanh niên', 20, NULL, 'Thuật đọc tâm', NULL, 4),
(46, b'1', 'Cuốn sách lật lại từng trang lịch sử thế giới qua cuộc hành trình của bác sĩ Kate Warner về với vùng đất Jakarta. Theo sau đó là tầng tầng lớp lớp những bí mật khoa học về con người và sự tiến hoá. Sức hút nằm ngay ở lượng thông tin mới mẻ mà tác giả cung cấp, về loại gene mang tên Atlantis, về những khám phá vĩ đại của con người. Một cánh cửa dẫn đến bước tiến hoá tiếp theo của loài người và viết lại lịch sử của giống loài có thể mở ra, nhưng đồng thời, nếu lọt vào tay Hội Immari – tổ chức cổ xưa đã 2000 năm lịch sử – đó cũng chính là sự kết thúc cho nhân loại.', 4, b'0', b'0', 287, 60000, 'NXB Hội nhà văn', 20, NULL, 'Gene Atlantis', NULL, 5),
(47, b'1', '“Bỏ lỡ một người, bỏ lỡ một đời” - Dành tặng những ai vì một nhịp trượt mà mất nhau trong đời. Trong cuộc đời này, có bốn thứ không bao giờ lấy lại được: Một là lời đã nói ra.Hai là mũi tên đã bắn đi. Ba là khoảng thời gian đã trôi qua. Và... cuối cùng, đau lòng nhất là những người đã từng bỏ lỡ.', 0, b'1', b'0', 297, 78000, 'NXB Phụ nữ', 24, NULL, 'Bỏ Lỡ Một Người, Bỏ Lỡ Một Đời', NULL, 6),
(17, b'1', 'Mục đích của Sera Masumi, nhân vật mới xuất hiện, là gì? Theo gợi ý của Sera, Conan và Heiji sẽ bước vào một cuộc đua tài phá án!! Trong tập truyện này, các bạn sẽ được phần kết của vụ bắt giữ con tin tại văn phòng thám tử Mori, vụ bắt cóc Ayumi, cùng cuộc đua tài của hai chàng thám tử miền Đông và miền Tây!!', 0, b'1', b'0', 220, 22000, 'NXB Kim đồng', 30, NULL, 'THÁM TỬ LỪNG DANH CONAN - TẬP 74 (TÁI BẢN 2019)', NULL, 8),
(19, b'1', 'Sách sinh học 7 sẽ mang đến cho các em chiếc chìa khóa khám phá thế giới tự nhiên đa dạng, đồng thời hiểu biết cơ bản về quá trình tiến hóa của động vật. ', 0, b'0', b'0', 22, 19000, 'NXB Giao dục Việt Nam', 15, NULL, 'Sinh học lớp 7', NULL, 2),
(18, b'1', 'Conan lại có đối thủ mới, liệu đó là bạn hay thù? Đâu là chân tướng của nhân vật bất ngờ xuất hiện và tự xưng là thám tử ấy... Hãy cùng đón xem phần kết của vụ án mạng liên quan tới người canh gác thờigian, vụ án ramen ngon chết người, và vụ khống chế con tin tại văn phòng thám tử Mori với những hành động không thể rời mắt của nhân vật mới nhé!! ', 0, b'1', b'0', 200, 22000, 'NXB Kim đồng', 30, NULL, 'THÁM TỬ LỪNG DANH CONAN TẬP 34 (TÁI BẢN 2019)', NULL, 8),
(21, b'1', 'Vào lớp 1, các em học sinh được Tiếng Việt, học Toán và các môn học khác, trong đó có môn Nghệ thuật. Phần Âm nhạc trong môn Nghệ thuật lớp 1 dẽ dạy các em học 12 bài hát.', 33, b'0', b'0', 30, 14000, 'NXB Giao dục Việt Nam', 15, NULL, 'Tập hát lớp 1', NULL, 2),
(20, b'1', 'Nội dung sách sẽ giúp các em làm quen với những ứng dụng của Công nghệ sinh học, hóa học, kinh tế họ trong các ngành sản xuất Nông - lâm - ngư nghiệp. Sách được biên soạn theo hướng đổi mới phương pháp đổi mới giáo dục, tích cực, chủ động, sáng tạo. Các bài học được trình bày theo cấu trúc: mục tiêu, cung cấp dữ liệu - thông tin về điều kiện, quy trình kỹ thuậ và gợi ý phương pháp xử lý thông tin.', 0, b'0', b'0', 35, 16000, 'NXB Giao dục Việt Nam', 15, NULL, 'Công nghệ lớp 10', NULL, 2),
(23, b'1', 'Bộ truyện tranh Truyện cổ tích Việt Nam sẽ đưa các em trở về thế giới cổ tích và gặp lại các nhân vật quen thuộc như: Thạch Sanh, cô Tấm, Thánh Gióng, chú Cuội, Sọ Dừa,...Qua những câu chuyện, các em sẽ biết được thêm nhiều sự tích thú vị về con người, sự vật, sự việc thường xuất hiện trong các áng văn thơ văn của dân tộc ta. Tất cả sẽ làm giàu thêm trí tưởng tượng vốn rất phong phú của các em, bồi dưỡng tâm hồn các em và giúp các em thêm yêu, thêm tin vào cổ tích.', 0, b'0', b'0', 56, 45000, 'NXB Văn học', 20, NULL, 'TRUYỆN CỔ TÍCH VIỆT NAM - SỰ TÍCH NÚI VÀNG', NULL, 3),
(22, b'1', 'Những câu chuyện ẩn dụ về lối sống ở hiền gặp lành của cha ông sẽ đưa các em tới thế giới cổ tích màu nhiệm, nơi điều thiện được trân trọng, cái ác bị trừng phạt; và để lại những bài học ý nghĩa, thú vị, đầy tinh thần hướng thiện.', 0, b'0', b'0', 70, 50000, 'NXB Văn học', 20, NULL, 'CỔ TÍCH VIỆT NAM - Ở HIỀN GẶP LÀNH', NULL, 3),
(25, b'1', 'Ta có thực sự là những cá nhân tự do với bản sắc riêng… hay tất cả chúng ta đều chỉ biết tuân phục số đông? Thiên tài là nhờ dưỡng dục hay tự nhiên? Vô thức điều khiển chúng ta như thế nào? Những câu hỏi như trên chính là tiền đề cho các công trình của nhiều tư tưởng gia và khoa học gia lớn của thế giới, trong một lĩnh vực giàu sức lôi cuốn, đó là tâm lí học.', 0, b'1', b'1', 125, 70000, 'NXB Dân Trí', 6, NULL, 'TÂM LÝ HỌC - KHÁI LƯỢC NHỮNG TƯ TƯỞNG LỚN', NULL, 4),
(24, b'1', 'Giữa vô vàn nỗi đau của chúng ta trong cuộc sống, có một cơn đau trầm lặng nhưng liên lỉ, ảnh hưởng sâu đậm đến tất cả những ai chạm đến nó. Không chỉ kẻ mang nỗi đau này mới là người vác thánh giá mà cả bố mẹ, anh em, bà con, và bạn bè cũng cùng sẻ chia trên đường khổ nạn. Nỗi đau đó, Nguyễn Thị Phương Hoa, một chuyên gia tâm lý và là một người mẹ, đã chia sẻ cùng bạn đọc trong tác phẩm, “Có Một Cơn Đau Mang Tên Trầm Cảm”.', 0, b'0', b'0', 144, 60000, 'NXB Văn hóa-Văn nghệ', 8, NULL, 'Có một cơn đau mang tên trầm cảm', NULL, 4),
(26, b'1', 'Người nhạy cảm được sinh ra với những xúc cảm tinh tế và mãnh liệt hơn người khác: dễ khóc, dễ cười, dễ đồng cảm với người khác, đôi khi thích thu mình, đôi khi lại muốn hòa nhập cùng mọi người, suy nghĩ về nhiều thứ, dễ cảm thấy lạc lõng, chỉ một kích thích nhỏ cũng khiến tinh thần bất ổn…', 11, b'0', b'0', 155, 59000, 'NXB Thế giới', 6, NULL, 'NGƯỜI NHẠY CẢM - MÓN QUÀ HAY LỜI NGUYỀN', NULL, 4),
(27, b'1', 'Vừa qua, Allan & Barbara Pease đã quay trở lại với quyển sách quan trọng nhất của họ: Tại sao đàn ông thích tình dục và phụ nữ cần tình yêu. Đây là một quyển sách hài hước, dễ đọc. Trong quyển sách này, họ đã tiết lộ một sự thật về hai phái; đồng thời bằng tài năng của mình, họ đã làm cho các kiến thức khoa học trở nên thú vị, lôi cuốn, dễ hiểu, qua đó hướng dẫn chúng ta cách vận dụng những kiến thức ấy để tìm kiếm tình yêu, giải quyết các rắc rối trong chuyện tình cảm và sống hạnh phúc hơn với người bạn đời.', 0, b'1', b'1', 69, 88000, 'NXB Tổng hợp TP HCM', 5, NULL, 'TẠI SAO ĐÀN ÔNG THÍCH TÌNH DỤC VÀ PHỤ NỮ CẦN TÌNH YÊU (TÁI BẢN 2019)', NULL, 4),
(29, b'1', 'Nếu lựa chọn của bạn tìm là một cuốn Sci-fi kinh điển, đây sẽ là cuốn sách dành cho bạn. Đến với cuốn sách này, bạn có thể bắt đầu một hành trình khám phá thế giới đại dương nhiều bí ẩn với thuyền trưởng Nemo và các thủy thủ trên tàu Nautilus.\r\n\r\nTác phẩm được viết bằng giọng văn lôi cuốn, tình tiết hấp dẫn với sự xuất hiện của những sinh vật biển và cuộc phiêu lưu thám hiểm đại dương của các nhân vật chính. Được phát hành lần đầu năm 1869, tác phẩm đến nay vẫn còn nguyên sức hút, đặc biệt là với những người ham tìm tòi về đại dương.\r\n\r\nSách có nhiều phiên bản phát hành tại Việt Nam, bạn đọc có thể tham khảo review hoặc đọc thử trên các trang bán để chọn ra bản dịch ưng ý nhất.', 0, b'0', b'0', 88, 145000, 'NXB Văn học', 5, NULL, 'Hai Vạn Dặm Dưới Biển', NULL, 5),
(28, b'1', 'Trước tuổi trưởng thành, người trẻ nào cũng đi qua một giai đoạn khó khăn, thậm chí là khủng hoảng liên quan đến tình yêu, giới tính, thậm chí cả tình dục. Nhu cầu cần được giải đáp, giải thích về tình yêu, giới tính, tình dục một cách khoa học của người trẻ là chính đáng và cần thiết. Những giải thích thiếu khoa học hoặc chỉ mang tính chất câu khách rẻ tiền trong một xã hội tràn ngập thông tin, cộng thêm việc không hiểu tâm sinh lý của con em từ chính các phụ huynh, nhiều khi đẩy người trẻ đến những bị kịch thương tâm.', 0, b'1', b'1', 72, 79000, 'Báo Hoa Học Trò', 4, NULL, 'LÀM SAO ĐỂ SỐNG HẠNH PHÚC?', NULL, 4),
(30, b'1', 'Trái đất đứng trước thảm họa tấn công của sinh vật vũ trụ Gitai, cậu thiếu niên Kiriya Kenji chính là chìa khóa mang lại hòa bình cho nhân loại. Vòng lặp được tái lập, cuộc chiến mới lại bắt đầu cho đến khi diệt sạch lũ quái vật... Tác phẩm là nguyên tác Sci-fi gây tiếng vang ở nhiều nước sau khi ra mắt, được chuyển thể thành manga, phim bom tấn Hollywood do diễn viên Tom Cruise thủ vai chính. \r\n\r\nDung lượng truyện khá ngắn, nhịp độ dồn dập kích thích ngay từ những trang đầu với không khí chiến trường khốc liệt. Sự kết hợp giữa truyện chữ và minh họa đặc trưng của dòng Light novel, giúp người đọc dễ nắm bắt nội dung cốt truyện hơn. Dù là người mới lần đầu đọc Sci-fi, bạn cũng có thể tận hưởng trọn vẹn chất khoa học viễn tưởng trong tác phẩm này.  ', 0, b'0', b'0', 112, 140000, 'NXB Hội nhà văn', 9, NULL, 'Cuộc Chiến Luân Hồi', NULL, 5),
(31, b'1', 'Bằng vỏ bọc Paprika – thám tử giấc mơ, Chiba Atsuko đã phát minh ra thiết bị DC Mini giúp các bác sĩ xâm nhập vào giấc mơ để điều trị cho các bệnh nhân. Biến cố bắt đầu khi 3 chiếc DC Mini bị đánh cắp, trên hành trình tìm lại DC Mini cô bắt đầu khám phá ra hiện thực của xã hội đen tối, phô bày hình hài méo mó trong bản chất con người...\r\n\r\nĐây là một tác phẩm khoa học tâm lý giả tưởng kịch tính, nghẹt thở, nơi tác giả đã xây dựng nên một thế giới nhập nhằng giữa hư thực khi con người có khả năng đi vào giấc mơ của người khác. Mặt tối của xã hội hiện đại được khéo léo lồng ghép trong bối cảnh viễn tưởng, dấy lên nhiều suy ngẫm về bản chất con người. Tác phẩm có nội dung và bối cảnh gần gũi với đời thực, khiến bạn dễ dàng hòa vào không khí của mạch truyện.', 5, b'0', b'0', 100, 134000, 'NXB Phụ nữ', 15, NULL, 'Kẻ Trộm Giấc Mơ', NULL, 5),
(32, b'1', '“Người Máy Có Mơ Về Cừu Điện Không” là một cuốn sách nhất định phải đọc của một bậc thầy khoa học viễn tưởng ở thế kỉ 20 - Philip K.Dick. Cuốn tiểu thuyết bao gồm 22 chương nói về một thế giới sau Chiến tranh thế giới thứ 3 với nhiều biến đổi về khoa học, chính trị và xã hội.\r\n \r\nNhân vật chính trong tác phẩm - Rick Deckard - người mang sứ mệnh tìm kiếm những người máy trốn thoát từ Sao Hỏa và đang ẩn náu tại Trái Đất. Từ đó, cuốn sách cất lên những vấn đề triết học đang cần lời giải thích: điều gì đã tạo nên yếu tố con người, người máy có cảm xúc không và con người nên nhìn nhận chúng như thế nào. \r\n \r\nĐây là một cuốn sách viễn tưởng mang hơi hướng triết học nhưng không hề khô khan mà ngược lại còn rất hấp dẫn và lôi cuốn.', 0, b'0', b'0', 60, 102000, 'NXB Văn học', 7, NULL, 'NGƯỜI MÁY CÓ MƠ VỀ CỪU ĐIỆN KHÔNG?', NULL, 5),
(33, b'1', ' Bạn có bao giờ thắc mắc rằng thế giới trong tương lai sẽ trở nên như thế nào khi càng ngày tình người càng bị lạm dụng vào công nghệ hiện đại và giá trị vật chất. Cuốn sách của tác giả Ray Bradbury đã mở ra cho người đọc thấy một viễn cảnh đáng sợ trong tương lai qua giọng văn đầy sức gợi cảm và chất chứa một sự lạnh lùng đến đáng sợ.\r\n \r\nCâu chuyện trong tác phẩm khiến ta bị ngạt thở trong nỗi sợ hãi, nỗi đau đớn và cả chết chóc. Đây là một cuốn sách khoa học viễn tưởng nhưng lại chân thật đến từng chi tiết, bên cạnh đó còn xen lẫn những cảm xúc thuần túy nhất trong trái tim con người.', 0, b'0', b'0', 80, 98000, 'NXB Văn học', 10, NULL, 'Người minh hoạ', NULL, 5),
(48, b'1', 'Những câu chuyện về chú mèo máy thông minh Doraemon và nhóm bạn Nobita, Shizuka, Suneo, Jaian, Dekisugi sẽ đưa chúng ta bước vào thế giới hồn nhiên, trong sáng đầy ắp tiếng cười với một kho bảo bối kì diệu - những bảo bối biến ước mơ của chúng ta thành sự thật. Nhưng trên tất cả Doraemon là hiện thân của tình bạn cao đẹp, của niềm khát khao vương tới những tầm cao.', 0, b'1', b'0', 88, 20000, 'NXB Kim đồng', 10, NULL, 'DORAEMON - CHÚ MÈO MÁY ĐẾN TỪ TƯƠNG LAI TẬP 8 (TÁI BẢN 2019)', NULL, 8);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `code`, `name`) VALUES
(1, 'giao-duc', 'Giáo dục'),
(2, 'sach-giao-khoa', 'Sách Giáo Khoa'),
(3, 'co-tich-than-thoai', 'Cổ tích-Thần thoại'),
(4, 'tam-li', 'Tâm lí'),
(5, 'khoa-hoc-vien-tuong', 'Khoa học-Viễn tưởng'),
(6, 'tinh-cam', 'Tình cảm'),
(7, 'trinh-tham', 'Trinh thám'),
(8, 'truyen-tranh', 'Truyện tranh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `review` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `confirmation_token`
--

CREATE TABLE `confirmation_token` (
  `token_id` bigint(20) NOT NULL,
  `confirmation_token` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `media`
--

CREATE TABLE `media` (
  `id` bigint(20) NOT NULL,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `media`
--

INSERT INTO `media` (`id`, `path`, `book_id`) VALUES
(18, 'web/CDweb/8/conan-34.jpg', 18),
(17, 'web/CDweb/8/conan-74.jpg', 17),
(16, 'web/CDweb/8/conan-la-thu-thach-dau.jpg', 16),
(48, 'web/CDweb/8/doraemon-tap-8.jpg', 48),
(14, 'web/CDweb/8/doraemon-tuyen-tap-truyen-mau-ky-thuat-so.jpg', 14),
(15, 'web/CDweb/8/fujiko-doraemon-tap-11.jpg', 15),
(36, 'web/CDweb/7/an-mang-tren-song-nile.jpg', 36),
(38, 'web/CDweb/7/hoa-nguc.jpg', 38),
(37, 'web/CDweb/7/Mat_ma_davinci.jpg', 37),
(39, 'web/CDweb/7/mau_lanh.jpg', 39),
(41, 'web/CDweb/7/sat-nhan-mang.jpg', 41),
(40, 'web/CDweb/7/su-im-lang-cua-bay-cuu.jpg', 40),
(12, 'web/CDweb/1/Phat-trien-thong-minh-4-tuoi.png', 12),
(11, 'web/CDweb/1/Phat-trien-thong-minh-5-tuoi.png', 11),
(10, 'web/CDweb/1/Phat-trien-thong-minh-6-tuoi.png', 10),
(43, 'web/CDweb/2/150-bai-van-lop-12.jpg', 43),
(2, 'web/CDweb/2/bo-sach-lop-6.jpg', 2),
(20, 'web/CDweb/2/cong-nghe-10.jpg', 20),
(19, 'web/CDweb/2/sinh-hoc-7.jpg', 19),
(21, 'web/CDweb/2/tap-hat-1.jpg', 21),
(3, 'web/CDweb/2/vat-li-9.jpg', 3),
(9, 'web/CDweb/3/andecxen.png', 9),
(22, 'web/CDweb/3/o-hien-gap-lanh.jpg', 22),
(8, 'web/CDweb/3/rump.jpg', 8),
(23, 'web/CDweb/3/su-tich-nui-vang.jpg', 23),
(44, 'web/CDweb/3/than-thoai-the-gioi.jpg', 44),
(7, 'web/CDweb/3/truyen-co-tich-vn-hay-nhat-tap-1.jpg', 7),
(28, 'web/CDweb/4/lam-sao-de-song-hanh-phuc.jpg', 28),
(24, 'web/CDweb/4/mot-con-dau-mang-ten-tram-cam.jpg', 24),
(26, 'web/CDweb/4/nguoi-nhay-cam.jpg', 26),
(27, 'web/CDweb/4/tai-sao-dan-ong-thich.jpg', 27),
(25, 'web/CDweb/4/tam-li-hoc.jpg', 25),
(45, 'web/CDweb/4/thuat-doc-tam.jpg', 45),
(30, 'web/CDweb/5/cuoc-chien-luan-hoi.jpg', 30),
(46, 'web/CDweb/5/gene_atlantis.jpg', 46),
(31, 'web/CDweb/5/ke_trom_giac_mo.jpg', 31),
(32, 'web/CDweb/5/nguoi-may-co-mo-ve-cuu-dien-khong.jpg', 32),
(33, 'web/CDweb/5/nguoi-minh-hoa.jpg', 33),
(29, 'web/CDweb/5/sach-hai-van-dam-duoi-day-bien-214x300.gif', 29),
(47, 'web/CDweb/6/bo-lo-mot-nguoi.jpg', 47),
(35, 'web/CDweb/6/don-phuong-anh-khong-thuong-em.jpg', 35),
(4, 'web/CDweb/6/ho-ly-biet-yeu.jpg', 4),
(6, 'web/CDweb/6/khu-vuon-ngon-tu.jpg', 6),
(5, 'web/CDweb/6/mai-mai-la-bao-xa.jpg', 5),
(34, 'web/CDweb/6/nghe-noi-anh-muon-chia-tay.jpg', 34),
(42, 'web/CDweb/1/Khung-long-co-de-trung-khong.jpg', 42),
(1, 'web/CDweb/1/Len-nui-cao.jpg', 1),
(13, 'web/CDweb/1/Nhung-mang-mau-du-lich-vn.png', 13);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `short_description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `thumbnail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ordered`
--

CREATE TABLE `ordered` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ordered_date` datetime DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `received_date` datetime DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ordered_item`
--

CREATE TABLE `ordered_item` (
  `id` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `ordered_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `password_reset_token`
--

CREATE TABLE `password_reset_token` (
  `token_id` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `series` varchar(255) COLLATE utf8_bin NOT NULL,
  `last_used` datetime DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shopping_cart`
--

CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `address`, `email`, `full_name`, `is_enabled`, `password`, `phone`) VALUES
(1, '', 'thiensubanphuc000@gmail.com', 'Tô Thảo Nhả', b'1', '$2a$10$NSMrymaIjEIGjFHxbacqmu0LbPvv5VolQBhSJj8hB3tOwGTykiM0.', ''),
(7, 'abc', '17130008@st.hcmuaf.edu.vn', 'nhu anh', b'1', '$2a$10$qGRUuBbVCZmCpjswzXOcQeUy3aoG755vy2dtLWY46S7al39mtcMJu', '0898450938'),
(6, 'abc', 'jennyvu8202@gmail.com', 'nhu anh', b'0', '$2a$10$.wk/YHCjnuTEXwanA3d9T.2W56zYvQ6BpJdDIuxitLDEUvBiKhVF2', '0898450938');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(6, 1),
(7, 1),
(1, 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKklnrv3weler2ftkweewlky958` (`author_id`),
  ADD KEY `FKam9riv8y6rjwkua1gapdfew4j` (`category_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `CATEGORY_UK` (`code`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkko96rdq8d82wm91vh2jsfak7` (`book_id`),
  ADD KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`);

--
-- Chỉ mục cho bảng `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD PRIMARY KEY (`token_id`),
  ADD UNIQUE KEY `CT_UK` (`confirmation_token`),
  ADD KEY `FKhjrtky9wbd6lbk7mu9tuddqgn` (`user_id`);

--
-- Chỉ mục cho bảng `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbiulouweyg0pg8a1piqsajr9u` (`book_id`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `ordered`
--
ALTER TABLE `ordered`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjqbh5jbj1olkur6fpmle5r9ev` (`user_id`);

--
-- Chỉ mục cho bảng `ordered_item`
--
ALTER TABLE `ordered_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd88l2xxcikhau7to4dba440hu` (`book_id`),
  ADD KEY `FKfyed8s2qkifmpo0ssjkawe322` (`ordered_id`);

--
-- Chỉ mục cho bảng `password_reset_token`
--
ALTER TABLE `password_reset_token`
  ADD PRIMARY KEY (`token_id`),
  ADD KEY `FK5lwtbncug84d4ero33v3cfxvl` (`user_id`);

--
-- Chỉ mục cho bảng `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `shopping_cart`
--
ALTER TABLE `shopping_cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1sxgwv5nvek5hcv0or8302xge` (`book_id`),
  ADD KEY `FK254qp5akhuaaj9n5co4jww3fk` (`user_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `USER_UK` (`email`);

--
-- Chỉ mục cho bảng `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `author`
--
ALTER TABLE `author`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `banner`
--
ALTER TABLE `banner`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `comment`
--
ALTER TABLE `comment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `media`
--
ALTER TABLE `media`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT cho bảng `news`
--
ALTER TABLE `news`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ordered`
--
ALTER TABLE `ordered`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ordered_item`
--
ALTER TABLE `ordered_item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `shopping_cart`
--
ALTER TABLE `shopping_cart`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
