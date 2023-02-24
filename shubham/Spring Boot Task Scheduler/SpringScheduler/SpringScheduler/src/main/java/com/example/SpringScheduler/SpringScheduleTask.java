package com.example.SpringScheduler;

import java.io.Console;
import java.util.logging.*;

import javax.sound.midi.SysexMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

@Component
@EnableAsync
public class SpringScheduleTask {

    int i=0;

//    @Scheduled(cron = "0 52,53 15 * * ?")
//    public void ScheduleTask()
//    {
//        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//        final VoiceManager voiceManager = VoiceManager.getInstance();
//        System.out.println("Hello"+voiceManager.getVoices());
//        final Voice voice = voiceManager.getVoice("kevin16");
//        voice.allocate();
//        voice.speak("You can get everything in life you want if you will just help enough other people get what they want");
//    }


    @Scheduled(cron = "* * * * * *")
    public  void ScheduleTasksfixedDelay()
    {
        System.out.println("Hi");
    }






    //fixed delay
//    @Scheduled(fixedDelay = 1000)
//    public  void ScheduleTasksfixedDelay()
//    {
//        System.out.println("Hi");
//    }
    //inital delay with fixed delay

//    @Scheduled(initialDelay = 3000,fixedDelay = 100)
//    public void ScheduleTasksIntialDelay()
//    {
//        System.out.println("Intial Delay");
//    }

    //fixed Rate
//     @Async
//     @Scheduled(fixedRate =1)
//     public void ScheduledTaskWithFixedRate()
//     {
//         for(int i=0;i<1000;i++)
//         {
//             System.out.println(i);
//         }
//     }
}
