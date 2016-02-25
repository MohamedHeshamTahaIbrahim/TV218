package rytalo.com.tv218;

/**
 * Created by محمد on 25/02/2016.
 */


/**
 * Created by محمد on 22/02/2016.
 */
public class ProgramsCommunication {
    ProgramsModel programsModel=new ProgramsModel();
    public String [] displayProgramsName(){

        String[] programsName = {
                "في الخارج",
                "نحن و العالم",
                "GAME",
                "الحكومة",
                "فن",
                "برامج منوعة",
                "الصبح",
                "الأخبار",
                "البلاد",
                "العشية"
        };
        String [] programsNameValue;
        programsModel.setProgramNames(programsName);
        programsNameValue=programsModel.getProgramNames();
        return programsNameValue;

    }
    public String [] displayProgramsDescription(){
        String[] programsDescription ={
                "برنامج اجتماعي اسبوعي عن حياة الليبيين في الخارج",
                "برنامج سياسي عربي. أسبوعي مباشر",
                "برنامج رياضي. أسبوعي. مباشر. لمدة ساعة من الزمن. ",
                "برنامج سياسي أسبوعي يتابع أهم أخبار المجلس الحكومي.",
                "برنامج فني. أسبوعي. مسجل. لمدة ساعة من الزمن. ",
                "برامج منوعة تقدمها لكم قناة 218 وتناقش فيها مختلف القضايا ",
                "برنامج صباحي مباشر. يعرض خلال نهاية الأسبوع. لمدة ساعتين من الزمن.",
                "أهم الأخبار.. وجميع المواضيع و القضايا التي تخص الشأن الليبي و العربي و أيضاٌ العالمي ",
                "برنامج سياسي مباشر. يعرض على 5 أيام في الأسبوع. لمدة ساعتين من الزمن. ",
                "برنامج شبابي مباشر (فترة العصر) tea time show. يعرض على 5 أيام في الأسبوع. "
        };
        String [] programsDescriptionValue;
        programsModel.setProgramDescription(programsDescription);
        programsDescriptionValue=programsModel.getProgramDescription();
        return programsDescriptionValue;
    }
    public Integer []displayProgramsImages(){
        Integer [] programsImage={
                R.drawable.outside,
                R.drawable.world1,
                R.drawable.game1,
                R.drawable.hkooma,
                R.drawable.fan,
                R.drawable.pmerage,
                R.drawable.alsob7,
                R.drawable.news1,
                R.drawable.albilad,
                R.drawable.al3ashya
        };
        Integer []programsImageValue;
        programsModel.setProgramImages(programsImage);
        programsImageValue=programsModel.getProgramImages();
        return programsImageValue;
    }
}
