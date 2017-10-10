# lunchinator
REST API for Lunchinator 3000 

Steps to run:
1. clone the git repo
2. cd to the lunchinator code directory (where the build.gradle file is)
3. gradle build
4. gradle bootRun (wait a few seconds...)

You are now ready to issue the api requests. I developed it using Postman. I have created a Postman collection for convenience in src/test/resources, but feel free to hand craft the requests.


Stuff I learned:
1. gradle - I can't say I had much gradle experience until now. I still have a lot to learn, but I think I can get around well enough now.
2. SpringBoot - Wow! I can't say enough good about this little gem. I hunted around a lot looking for a good way to rapidly prototype the apis not knowing how you would run them. When I found the gradle plugin for spring boot and after playing with it for about 10 minutes, I knew I had a winner.
3. The different return objects for /api/ballot/{ballotId} sort of spun me around for a while. It didn't seem restful to me because I always was taught that a resource is a resource. This just seemed "un" restful...but we can talk about that. Maybe it makes sense this way.
4. I got a crash course refresher in spring framework. And I needed it!


Stuff to do:
1. I ran out of time and did not get any JUnit tests done. I will punish myself later for this. :-)
2. Validations. oy...I skipped a lot of validations. The system is brittle. 
3. Refactoring needs to be done to make sure I'm following good SOLID principles. I would like to take another pass or two to make sure it is DRY too.
4. Integration with other services. I just didn't have time to do it.
5. A host of other items that need to be done but didn't get to.

Anyway, hopefully, this is enough to talk about. I admit the whole sytem is pretty rough, but I did only work on it about 7 hours and I think there is probably a few more hours I could spend on it. I most certainly will, but, for now, I hope this is good enough to go forward.

I really enjoyed working on this little project! It gaveme an opportunity to learn some skills that I wanted to learn anyway and to knock the rust off of some others that needed some serious oil.