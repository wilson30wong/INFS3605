package com.example.infs3605v1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Exercise;
import com.example.infs3605v1.database.Helpline;
import com.example.infs3605v1.database.Learn;
import com.example.infs3605v1.methods.Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar mainLoadingCircle;
    TextView mainLoadingMessage;

    Intent intent;
    Timer timer;
    TimerTask timerTask;
    AppDatabase db;
    ArrayList<Learn> learnList;
    Learn[] insertLearnDb;
    ArrayList<Helpline> helplineList;
    Helpline[] insertHelplineDb;
    ArrayList<Exercise> exerciseList;
    Exercise[] insertExerciseDb;
    Methods methods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLoadingCircle = findViewById(R.id.mainLoadingCircle);
        mainLoadingMessage = findViewById(R.id.mainLoadingMessage);

        db = AppDatabase.getInstance(getApplicationContext());
        intent = new Intent(getApplicationContext(), LoginActivity.class);
        timerTask = new LoadingTask();
        timer = new Timer();
        timer.schedule(timerTask, 3000);

        methods = new Methods(getApplicationContext());
//        methods.clearDatabase();
    }

    class LoadingTask extends TimerTask {
        public void run() {
            populateLearn();
            populateHelpline();
            populateExercise();
            finish();
            startActivity(intent);
        }
    }

    private void populateLearn() {
        learnList = new ArrayList<Learn>();
        learnList.add(new Learn(
                "depression",
                "Depression is an extremely common mental disorder that is often identified by persistent feelings of sadness, loss, lowered self-esteem, and exhaustion to name a few characteristics. This mood disorder can affect you in various ways such as impinging on your general level of productivity or influencing your relationships and the way you interact with others. There are many different possible factors that can lead to depression, some of which include existing ailments, severe trauma, conflict, death or loss of loved ones, financial strain, genetics, and other personal or environmental problems.\n" +
                        "\n" +
                        "It is important to recognise that this is a serious condition that affects both your mental and physical health, and is not simply a case of being sad or low. As such, it cannot be easily solved by simply “snapping out of it”, and usually requires long-term treatment toa void worsening the condition. Some of these treatment measures include psychotherapy and medication, with improvements in symptoms often being observed within a few weeks.",
                "•\tAngry outbursts, irritability or frustration, even over small matters\n" +
                        "•\tLoss of interest or pleasure in most or all normal activities, such as sex, hobbies or sports\n" +
                        "•\tFeelings of sadness, tearfulness, emptiness or hopelessness\n" +
                        "•\tSleep disturbances, including insomnia or sleeping too much\n" +
                        "•\tTiredness and lack of energy, so even small tasks take extra effort\n" +
                        "•\tReduced appetite and weight loss or increased cravings for food and weight gain\n" +
                        "•\tAnxiety, agitation or restlessness\n" +
                        "•\tSlowed thinking, speaking or body movements\n" +
                        "•\tFeelings of worthlessness or guilt, fixating on past failures or self-blame\n" +
                        "•\tTrouble thinking, concentrating, making decisions and remembering things\n" +
                        "•\tFrequent or recurrent thoughts of death, suicidal thoughts, suicide attempts or suicide\n" +
                        "•\tUnexplained physical problems, such as back pain or headache\n" +
                        "\n" +
                        "You may have depression if you have thoughts similar to the ones listed below:\n" +
                        "•\t'I’m a failure'\n" +
                        "•\t'It’s my fault'\n" +
                        "•\t'Nothing good ever happens to me'\n" +
                        "•\t'I’m worthless'\n" +
                        "•\t'Life’s not worth living'\n" +
                        "•\t'People would be better off without me'",
                "These are some suggestions that can help you manage with depression. If you feel overwhelmed or unable to deal with your feelings, you can always contact your doctor or a mental health professional.\n" +
                        "•\tTalk to a friend or loved one\n" +
                        "•\tTake up some form of regular exercise\n" +
                        "•\tDevelop a routine for yourself (e.g. getting up at a normal, regular time)\n" +
                        "•\tCall a hotline\n" +
                        "•\tContact a minister, spiritual leader  or someone else in your faith community\n" +
                        "•\tMake an appointment to see your doctor or a mental health professional",
                "Coming Soon!"
        ));
        learnList.add(new Learn(
                "anxiety",
                "Anxiety is the most common mental health condition in Australia, with one in five men and one in three women experiencing this mental disorder at some point in their lives. It can be thought of as perpetual feeling of being worried or fearful and is actually your body’s natural response to stress. It is important to distinguish between normal anxiety and a more serious problem. For instance, it is quite common for an individual to experience anxiety when placed in new or uncomfortable situations, such as starting at a new school or job or even having some challenging financial conditions. However, prolonged periods of anxiety, or exceptionally strong worries that affect your quality of life can point towards more severe forms of anxiety disorders. \n" +
                        "\n" +
                        "There are many different types of anxiety disorders, some of which include panic disorders, social anxiety disorders, separation anxiety disorders, and other phobias. Causes of anxiety include genetic factors, brain chemistry, life events and environmental factors that are out of an individuals’ control. In terms of treatments, there are many approaches one can take to tackle anxiety. In some cases, medication such as sedatives and antidepressants can be used for moderation. Alternatively, psychotherapy is often used to combat severe anxiety. Nonetheless, it is also possible to avoid both of these mainstream forms of treatment, with more trivial action such as changes in lifestyle, environment or even natural remedies being enough in some cases. The important thing to note here is that there are a range of options that can help, and no one treatment will suit everyone.",
                "•\tFeeling nervous, restless or tense\n" +
                        "•\tHaving a sense of impending danger, panic or doom\n" +
                        "•\tHaving an increased heart rate\n" +
                        "•\tBreathing rapidly (hyperventilation)\n" +
                        "•\tSweating\n" +
                        "•\tTrembling\n" +
                        "•\tFeeling weak or tired\n" +
                        "•\tTrouble concentrating or thinking about anything other than the present worry\n" +
                        "•\tHaving trouble sleeping\n" +
                        "•\tExperiencing gastrointestinal (GI) problems\n" +
                        "•\tHaving difficulty controlling worry\n" +
                        "•\tHaving the urge to avoid things that trigger anxiety\n" +
                        "\n" +
                        "You may have anxiety if you have thoughts similar to the ones listed below:\n" +
                        "•\teverything’s going to go wrong’\n" +
                        "•\t‘I might die’\n" +
                        "•\t‘I can’t handle the way I feel’\n" +
                        "•\t‘I can’t focus on anything but my worries’\n" +
                        "•\t‘I don’t want to go out today’\n" +
                        "•\t‘I can’t calm myself down’",
                "These are some suggestions that can help you manage with anxiety. If you feel overwhelmed or unable to deal with your feelings, you can always contact your doctor or a mental health professional.\n" +
                        "•\tPractice focused, deep breathing exercises or meditation\n" +
                        "•\tGo for a walk\n" +
                        "•\tWrite down your thoughts\n" +
                        "•\tIdentify factors that trigger your worries\n" +
                        "•\tDevelop a healthy diet",
                "Coming Soon!"
        ));
        learnList.add(new Learn(
                "self-esteem",
                "Self-esteem or self-worth is an individual’s opinion of themselves that plays a vital role in one’s mental wellbeing. In particular, low self-esteem is a common contributing factor towards other mental health problems such as depression. Characteristics of low self-esteem include being unsatisfied with oneself, thinking oneself to be inferior to others, refusing to accept compliments, using negative words to describe oneself, and blaming oneself when things go badly. There are many different  causes of low self-esteem, some of which include stressful situations, poor performance at work or in school, destructive family relations, and other ongoing medical conditions. ",
                "•\tSaying negative things and being critical about yourself\n" +
                        "•\tFocusing on your negatives and ignoring your achievements\n" +
                        "•\tThinking other people are better than you\n" +
                        "•\tNot accepting compliments\n" +
                        "•\tFeeling sad, depressed, anxious, ashamed or angry\n" +
                        "\n" +
                        "You may have low self-esteem if you feel things similar to the ones below:\n" +
                        "•\tYou believe that others are better than you\n" +
                        "•\tYou find it difficult expressing your needs\n" +
                        "•\tYou focus on your weaknesses\n" +
                        "•\tYou frequently experience feelings such as shame, depression, or anxiety\n" +
                        "•\tYou have a negative outlook on life\n" +
                        "•\tYou have an intense fear of failure\n" +
                        "•\tYou have trouble accepting positive feedback\n" +
                        "•\tYou have trouble saying \"no\"\n" +
                        "•\tYou put other people's needs before your own\n" +
                        "•\tYou struggle with confidence",
                "These are some suggestions that can help you manage with low self-esteem. If you feel overwhelmed or unable to deal with your feelings, you can always contact your doctor or a mental health professional.\n" +
                        "•\tAvoid trying to do things perfectly\n" +
                        "•\tThink about your strengths and other things you like about yourself\n" +
                        "•\tDo things you enjoy\n" +
                        "•\tDo not dwell on mistakes\n" +
                        "•\tTake up some form of regular exercise\n" +
                        "•\tUse hopeful statements\n" +
                        "•\tFocus on the positive\n" +
                        "•\tSpent time with people who make you happy",
                "Coming Soon!"
        ));
        learnList.add(new Learn(
                "grief",
                "Grief is an extremely overwhelming and strong emotion and is an individual’s natural response to a major loss in their lives, such as the death of a loved one or a diagnosis of a serious disease. It is often associated with feelings of being despondent and numb to what is happening around yourself. In this way, grief can affect all aspects of one’s life.\n" +
                        "\n" +
                        "It is often better to accept that grief is unavoidable. The best way to deal with it is to prepare oneself for the different stages they will experience and understand why they are grieving. The generally accepted stages of grief are:\n" +
                        "•\tDenial: When you first learn of a loss, it is normal to think, “This isn’t happening.” You may feel shocked or numb. This is a temporary way to deal with the rush of overwhelming emotion. It is a defence mechanism.\n" +
                        "•\tAnger: As reality sets in, you are faced with the pain of your loss. You may feel frustrated and helpless. These feelings later turn into anger. You might direct it toward other people, a higher power, or life in general. To be angry with a loved one who died and left you alone is natural, too.\n" +
                        "•\tBargaining: During this stage, you dwell on what you could have done to prevent the loss. Common thoughts are “If only…” and “What if…” You may also try to strike a deal with a higher power.\n" +
                        "•\tDepression: Sadness sets in as you begin to understand the loss and its effect on your life. Signs of depression include crying, sleep issues, and a decreased appetite. You may feel overwhelmed, regretful, and lonely.\n" +
                        "•\tAcceptance: In this final stage of grief, you accept the reality of your loss. It cannot be changed. Although you still feel sad, you are able to start moving forward with your life.\n" +
                        "\n" +
                        "Generally, pain is tempered as time passes and as the bereaved adapts to life without a loved one, to the news of a terminal diagnosis or to the realisation that someone they love may die. It is important to understand that everyone experiences grief differently and therefore it is unproductive to compare oneself to another.",
                "•\tIntense sorrow, pain and rumination over the loss of your loved one\n" +
                        "•\tFocus on little else but your loved one's death\n" +
                        "•\tExtreme focus on reminders of the loved one or excessive avoidance of reminders\n" +
                        "•\tIntense and persistent longing or pining for the deceased\n" +
                        "•\tProblems accepting the death\n" +
                        "•\tNumbness or detachment\n" +
                        "•\tBitterness about your loss\n" +
                        "•\tFeeling that life holds no meaning or purpose\n" +
                        "•\tLack of trust in others\n" +
                        "•\tInability to enjoy life or think back on positive experiences with your loved one\n" +
                        "•\tIncreased irritability\n" +
                        "•\tNumbness\n" +
                        "•\tBitterness\n" +
                        "•\tDetachment\n" +
                        "•\tPreoccupation with loss",
                "These are some suggestions that can help you manage with grief. If you feel overwhelmed or unable to deal with your feelings, you can always contact your doctor or a mental health professional.\n" +
                        "•\tAccepting the reality of your loss\n" +
                        "•\tAllowing yourself to experience the pain of your loss\n" +
                        "•\tAdjusting to a new reality in which the deceased is no longer present\n" +
                        "•\tHaving other relationships",
                "Coming Soon!"
        ));
        learnList.add(new Learn(
                "bipolar",
                "Bipolar affective disorder is a psychological illness that involves severe mood swings which take the form of mania or depression. These swings can last for several months at a time, during which the individual may experience depressive episodes characterised by extreme sadness, feelings of hopelessness, lack of interest and low moods, or conversely manic episodes that involve racing thoughts and high moods. \n" +
                        "\n" +
                        "There are three different forms of bipolar affective disorder, which are:\n" +
                        "•\tType 1: patients have very  high manic periods and depressive episodes\n" +
                        "•\tType 2: patients have severe depressions but only mild manic episodes\n" +
                        "•\tType 3: patients only have mild depression and mild mania\n" +
                        "\n" +
                        "Episodes of mood swings may occur rarely or multiple times a year. While most people will experience some emotional symptoms between episodes, some may not experience any.\n" +
                        "\n" +
                        "Although bipolar disorder is a lifelong condition, you can manage your mood swings and other symptoms by following a treatment plan. In most cases, bipolar disorder is treated with medications and psychological counselling (psychotherapy).",
                "Symptoms of manic episodes\n" +
                        "•\tAbnormally upbeat, jumpy or wired\n" +
                        "•\tIncreased activity, energy or agitation\n" +
                        "•\tExaggerated sense of well-being and self-confidence (euphoria)\n" +
                        "•\tDecreased need for sleep\n" +
                        "•\tUnusual talkativeness\n" +
                        "•\tRacing thoughts\n" +
                        "•\tDistractibility\n" +
                        "•\tPoor decision-making — for example, going on buying sprees, taking sexual risks or making foolish investments\n" +
                        "\n" +
                        "Symptoms of depressive episodes:\n" +
                        "•\tDepressed mood, such as feeling sad, empty, hopeless or tearful (in children and teens, depressed mood can appear as irritability)\n" +
                        "•\tMarked loss of interest or feeling no pleasure in all — or almost all — activities\n" +
                        "•\tSignificant weight loss when not dieting, weight gain, or decrease or increase in appetite (in children, failure to gain weight as expected can be a sign of depression)\n" +
                        "•\tEither insomnia or sleeping too much\n" +
                        "•\tEither restlessness or slowed behavior\n" +
                        "•\tFatigue or loss of energy\n" +
                        "•\tFeelings of worthlessness or excessive or inappropriate guilt\n" +
                        "•\tDecreased ability to think or concentrate, or indecisiveness\n" +
                        "•\tThinking about, planning or attempting suicide",
                "These are some suggestions that can help you manage with bipolar affective disorder. If you feel overwhelmed or unable to deal with your feelings, you can always contact your doctor or a mental health professional.\n" +
                        "•\tDo not drink alcohol or use drugs as they can make your mood swings worse and nullify medications \n" +
                        "•\tDo not make major life changes or decisions while you are in a depressive episode\n" +
                        "•\tDevelop a routine for yourself (e.g. getting up at a normal, regular time, taking medications at the same time every day)\n" +
                        "•\tAsk a family member or friend for support",
                "Coming Soon!"
        ));
        insertLearnDb = learnList.toArray(new Learn[learnList.size()]);
        db.learnDao().insertAll(Arrays.asList(insertLearnDb));
    }

    private void populateHelpline(){
        helplineList = new ArrayList<Helpline>();
        helplineList.add(new Helpline(
                "mhaustralia.org",
                "6286 3100",
                "Mental Health Australia is an organisation that works in changing the public’s perception about people who are mentally ill.",
                "https://mhaustralia.org/sites/all/themes/mhca-theme/logo.png"
        ));
        helplineList.add(new Helpline(
                "www.beyondblue.org.au",
                "1300 22 4636",
                "Beyondblue is a national organisation that has a range of information and resources associated with depression and anxiety.",
                "https://www.beyondblue.org.au/app_themes/reskin/images/bb-logo.png"
        ));
        helplineList.add(new Helpline(
                "www.lifeline.org.au",
                "13 11 24",
                "Lifeline Australia provides a free, confidential, anonymous, 24-hour telephone counselling service for adults needing emotional support.",
                "https://seeklogo.com/images/L/lifeline-australia-logo-4129A48B6F-seeklogo.com.png"
        ));
        helplineList.add(new Helpline(
                "www.mensline.org.au",
                "1300 78 99 78",
                "Mensline Australia provides a free, confidential, and anonymous, 24-hour telephone counselling service for men needing emotional support or men in crisis.",
                "https://mensline.org.au/wp-content/uploads/2017/09/logo@2x.png"
        ));
        helplineList.add(new Helpline(
                "www.suicidecallbackservice.org.au",
                "1300 659 467",
                "The Suicide Call Back Service is a free nation-wide telephone support service available to support people at risk of suicide and their carers.",
                "https://media.healthdirect.org.au/images/logos/w300/SCBS_logo.png"
        ));
        insertHelplineDb = helplineList.toArray(new Helpline[helplineList.size()]);
        db.helplineDao().insertAll(Arrays.asList(insertHelplineDb));
    }

    private void populateExercise(){
        exerciseList = new ArrayList<Exercise>();
        exerciseList.add(new Exercise(
                "breathe",
                "Practice 4-7-8 breathing\n\nInhale to 4\nHold for 7\nExhale to 8"
        ));
        exerciseList.add(new Exercise(
                "self-soothe",
                "Take a shower, or bath, find a grounding object, and light a candle"
        ));
        exerciseList.add(new Exercise(
                "basic meditation",
                "Take a seat, focus on your breathing and allow your mind to wander"
        ));
        exerciseList.add(new Exercise(
                "pain relief",
                "Stretch\nTake deep breaths\nFocus on your body\nAcknowledge your thoughts"
        ));
        insertExerciseDb = exerciseList.toArray(new Exercise[exerciseList.size()]);
        db.exerciseDao().insertAll(Arrays.asList(insertExerciseDb));
    }

}



