// ملف واحد يحتوي على فئتين: Television و TelevisionViewer
public class TelevisionProgram {

    // فئة التلفاز التي تحتوي على القنوات
    static class Television {
        private int[] channels = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // قائمة القنوات
        private int currentIndex = 0; // تتبع القناة الحالية

        // دالة لإرجاع القنوات التي سيتم مشاهدتها
        public int[] getNextChannels() {
            int[] watchedChannels = new int[3]; // تخزين القنوات التي سيتم مشاهدتها
            for (int i = 0; i < 3; i++) {
                watchedChannels[i] = channels[currentIndex]; // اختيار القناة الحالية
                currentIndex = (currentIndex + 1) % channels.length; // الانتقال للقناة التالية مع الدوران
            }
            return watchedChannels;
        }
    }

    // فئة المشاهد التي تقوم بمحاكاة مشاهدة التلفاز
    static class TelevisionViewer {
        private Television tv = new Television(); // إنشاء كائن من التلفاز

        // دالة لمشاهدة التلفاز لعدد معين من الأيام
        public void watchTvForDays(int days) {
            for (int day = 1; day <= days; day++) {
                System.out.println("Woke up, day " + day);
                int[] channels = tv.getNextChannels(); // جلب القنوات التي سيتم مشاهدتها
                for (int channel : channels) {
                    System.out.println("Watching channel " + channel);
                }
                System.out.println("Falling asleep");
            }
        }
    }

    // الفئة الرئيسية لتشغيل البرنامج
    public static void main(String[] args) {
        TelevisionViewer viewer = new TelevisionViewer(); // إنشاء كائن من المشاهد
        viewer.watchTvForDays(10); // مشاهدة التلفاز لمدة 10 أيام
    }
}
