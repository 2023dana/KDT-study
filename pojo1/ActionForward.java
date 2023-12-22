// ActionForward 클래스 선언
public class ActionForward {
    // 멤버 변수 선언
    private String path = null;          // 리다이렉트 또는 포워딩할 경로를 저장하는 변수
    private boolean isRedirect = false;   // 리다이렉트 여부를 저장하는 변수

    // path 변수의 값을 반환하는 메서드
    public String getPath() {
        return path;
    }

    // path 변수에 값을 설정하는 메서드
    public void setPath(String path) {
        this.path = path;
    }

    // isRedirect 변수의 값을 반환하는 메서드
    public boolean isRedirect() {
        return isRedirect;
    }

    // isRedirect 변수에 값을 설정하는 메서드
    public void setRedirect(boolean isRedirect) {
        this.isRedirect = isRedirect;
    }
}
