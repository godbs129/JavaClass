package kr.hs.dgsw.java2.nio;

import java.nio.file.*;
import java.util.List;

public class FileStudy {

    public static void studyPath() throws Exception {
        Path path = Paths.get("/Users/haeyoon/Desktop/DGSW/Java/src/kr/hs/dgsw/java2/nio/test/nio");

        System.out.println(String.format("파일 이름 : %s", path.getFileName()));
        System.out.println(String.format("부모 디렉토리 : %s", path.getParent().getFileName()));
        System.out.println(String.format("중첩 경로 수 : %s", path.getNameCount()));

        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.getLastModifiedTime(path));
        System.out.println(Files.size(path));
        System.out.println(Files.getOwner(path));
        System.out.println(Files.isHidden(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
    }

    public static void studyFileManagement() throws Exception {
        System.out.println("파일 생성 삭제");

        Path dirPath = Paths.get("/Users/haeyoon/Desktop/DGSW/Java/src/kr/hs/dgsw/java2/nio/test/nio", "myDir");
        Path filePath = Paths.get("/Users/haeyoon/Desktop/DGSW/Java/src/kr/hs/dgsw/java2/nio/test/nio", "myDir", "helloo.txt");

        if (Files.notExists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }

        Path parentPath = Paths.get("/Users/haeyoon/Desktop/DGSW/Java/src/kr/hs/dgsw/java2/nio/test/nio");
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(parentPath);

        for (Path path : dirStream) {
            if (Files.isDirectory(path)) {
                System.out.println(String.format("디렉토리 : %s", path.getFileName()));
            } else {
                System.out.println(String.format("파일 : %s (%d)", path.getFileName(), Files.size(path)));
            }
        }
    }

    public static void studyWatchService() throws Exception {
        System.out.println("Watch");

        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("/Users/haeyoon/Desktop/DGSW/Java/src/kr/hs/dgsw/java2/nio/test/nio");
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        while (true) {
            WatchKey watchKey = watchService.take();

            List<WatchEvent<?>> events = watchKey.pollEvents();
            for(WatchEvent<?> event : events) {
                Path eventPath = (Path) event.context();
                WatchEvent.Kind<?> kind = event.kind();

                if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println(String.format("파일 %s 가 생성되었습니다", eventPath.getFileName()));
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println(String.format("파일 %s가 수정되었습니다", eventPath.getFileName()));
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println(String.format("파일 %s가 삭제되었습니다", eventPath.getFileName()));
                }
            }
            boolean valid = watchKey.reset();

            if (!valid) {
                break;
            }
        }

        watchService.close();
    }

    public static void main(String[] args) {
        try {
//            studyPath();
//            studyFileManagement();
            studyWatchService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
