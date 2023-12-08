package component;

public class SignInResult {
    private boolean success;  // Biến để chỉ đăng nhập thành công hay không
    private String errorMessage;  // Biến để lưu trữ thông báo lỗi (nếu có)

    // Constructors
    public SignInResult() {
        // Mặc định là không thành công và không có thông báo lỗi
        this.success = false;
        this.errorMessage = "";
    }

    public SignInResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    // Getters and setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

