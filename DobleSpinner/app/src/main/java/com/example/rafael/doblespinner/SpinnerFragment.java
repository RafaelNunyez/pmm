package com.example.rafael.doblespinner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class SpinnerFragment extends Fragment {

    Spinner studios = null;
    Spinner works = null;

    ArrayList<Studios> autores = new ArrayList<Studios>(
            Arrays.asList(
                    new Studios(0, "MadHouse Inc.", "Tokyo (Japan)", 1972, R.drawable.madhouse, new ArrayList<Movies> (
                            Arrays.asList(
                                    new Movies(0, "Summer Wars", 2009, R.drawable.summer,
                                            "Kenji Koiso is a young student at Kuonji High School with a gift for mathematics and a part-time moderator in the massive computer-simulated virtual reality world OZ along with his friend Takashi Sakuma.\n" +
                                                    "\n" +
                                                    "One day, Kenji is invited by fellow Kuonji student Natsuki Shinohara to participate in her great-grandmother Sakae Jinnouchi's 90th birthday. After traveling to Sakae's estate in Ueda, Natsuki introduces Kenji as her fiancé to Sakae, surprising them both. Kenji meets several of Natsuki's relatives and discovers that the Jinnouchis are descendants of a samurai (vassal of the Takeda clan) who challenged the Tokugawa clan in 1615. He also meets Wabisuke Jinnouchi, Natsuki's half-great-uncle and a computer expert who has been living in the United States since stealing the family fortune 10 years ago.\n" +
                                                    "\n" +
                                                    "Kenji receives an e-mail with a mathematical code and cracks it. Love Machine, an artificial intelligence written by Wabisuke, uses Kenji's account and avatar to hack the infrastructure, causing widespread damage. Kenji, Sakuma, and Natsuki's cousin Kazuma Ikezawa confront Love Machine. Love Machine defeats Kazuma's avatar King Kazma and continues to consume accounts in the OZ mainframe, creating catastrophic traffic congestion and disabling electrical devices. Two of Sakae's relatives, Rika and Shota Jinnouchi, discover Kenji's involvement. Shota arrests Kenji, but the congestion causes Natsuki to return them to the estate.\n" +
                                                    "\n" +
                                                    "Sakae calls associates in important positions in Japanese society and relatives who work in emergency services, encouraging them to work their hardest to reduce chaos and damage, comparing the situation to war. Kenji is able to return control of the mainframe to the moderators and engineers. Wabisuke explains that he sold the program to the United States Armed Forces for a test run. After an argument with Sakae, Wabisuke leaves the estate. Sakae later encourages Kenji to take care of Natsuki during a Koi-Koi match.\n" +
                                                    "\n" +
                                                    "The next morning, Sakae is discovered dead by Kenji and the Jinnouchis. Her youngest son Mansaku explains that she had angina, and that Love Machine had deactivated her heart monitor. Kenji, Sakuma, and most of the Jinnouchis initiate a plan to defeat Love Machine with a supercomputer using ice blocks as a coolant, while Natsuki and the others prepare a funeral for Sakae.\n" +
                                                    "\n" +
                                                    "Kenji, along with Sakuma and the others, capture Love Machine, but Shota carries the ice blocks to Sakae's body, causing the supercomputer to overheat. Love Machine consumes King Kazma and redirects the Arawashi Asteroid Probe onto a collision course with a nuclear power plant. Meanwhile, Natsuki discovers a will left by Sakae and reunites with Kenji and the rest of the group. Natsuki has Wabisuke return home before the family reads Sakae's will, asking them to bring Wabisuke back to their lives. Realizing that Love Machine sees everything as a game, Kenji has the Jinnouchis confront Love Machine to play Koi-Koi in OZ's casino world, wagering their accounts in a desperate attempt to stop Love Machine. Natsuki wins several rounds, but gets distracted and nearly loses her \"winnings\".\n" +
                                                    "\n" +
                                                    "However, OZ users worldwide enter their own accounts into the wager on Natsuki's side, which also prompts the guardian programs of OZ—the blue and red whales known as John and Yoko—to upgrade Natsuki's account. Natsuki wagers the 150 million avatars given to her in a single hand and critically damages Love Machine, prompting the artificial intelligence to redirect the Arawashi towards Sakae's estate. Kenji attempts to break into the probe's GPS, while Wabisuke disables Love Machine's defenses. After being revived and assisted by several of the Jinnouchi family's avatars, King Kazma destroys Love Machine. Kenji activates the GPS code to redirect the Arawashi away from the estate, destroying the estate's entrance and causing a geyser to erupt. In the aftermath, the Jinnouchi family, celebrating their victory as well as Sakae's birthday, has Natsuki kiss Kenji after they confess their love to each other. "),
                                    new Movies(1, "Hunter × Hunter: The Last Mission", 2013, R.drawable.hxh,
                                            "The film begins before the plot of Hunter x Hunter, some decades ago, when the chairman of the Hunters Association, Isaac Netero, defeats a powerful enemy known as Jed. Back to the present, a group of cloaked men storm into a prison and free the captives there, recruiting them for their plan. Some time later, Gon and Killua take a break from his expeditions with Kite to pay another visit at Heaven's Arena and cheer for their friend Zushi in the Battle Olympia Tournament with Wing and Biscuit. Meanwhile, Leorio, who is also bound to meet them, is attacked and knocked out by the cloaked men. Before the tournament begins, Gon and Killua pay a visit to Netero, who is also at the building, but the Arena is taken over by the mysterious men, with one of them, Gaki, replacing Zushi's first opponent and defeating him, another one, Shura, taking over the security system and a third one, Rengoku, stabbing herself and putting a curse on Netero to seal his Nen and immobilizing him. The ringleader then appears and knocks Gon and Killua down from the tower, but the duo manage to avoid the fall and return to the building, several floors below.\n" +
                                                    "\n" +
                                                    "Netero recognizes the ringleader as Jed, and it is revealed that Jed was once Netero's friend and leader of \"Shadow\", the Hunter Association's black ops squad, that was destroyed by the chairman after they began to make use of \"On\", a cursed power that is opposite to Nen and is fueled by the user's pure hatred. Jed and his companions objective is to force the Hunter Association to disclose the \"Black Report\", a record of the crimes against the descendants of \"Shadow\" to the public, that had peacefully settled after the organization was destroyed, but some time later were wrongly pursued and hunted down by the government, with three survivors, Gaki, Shura and Rengoku, to use their hatred to revive Jed, who teaches them to use On. Meanwhile, Gon and Killua fight their way up the tower until Gaki appears to fight them, and Kurapika, who was present at the tournament to escort his employer, Neon, confronts Shura. Amidst the chaos, Leorio rises from the sewers inside the building and is helped by Hisoka, who also was inside the building to reunite with Kurapika. Once Gon and Killua defeat Geki, he self-destructs as his conevant states that losing to a Hunter will cost his life. Kurapika also defeats Shura with Leorio's help, but before dying, Shura infects Kurapika with Jed's blood, sealing his Nen and claiming that he will die unless he embraces On instead.\n" +
                                                    "\n" +
                                                    "Once reunited with the others, Gon and Killua decide to confront Jed at the roof while Leorio stays behind to take care of Kurapika. In the occasion, Gon is also infected by his blood and decides to embrace On to keep fighting him, while Killua convinces Rengoku to give up on her hatred and she passes away, freeing Netero from her curse. Netero confronts Jed, but instead of attacking him, he decides to defend all his attacks until the hatred on him subsides. Jed is ultimately defeated when Gon purifies the On in his body with his own Nen and does the same to him, allowing him to finally pass away in peace. After the remaining members of Shadow are defeated, Heaven's Arena returns to normal and the Battle Olympia Tournament is finally allowed to begin. "),
                                    new Movies(2, "The Girl Who Leapt Through Time\n(Toki o Kakeru Shōjo)", 2006, R.drawable.time,
                                            "At Kuranose High School in Tokyo, Japan, Makoto Konno discovers a message written on a blackboard and inadvertently falls upon a walnut-shaped object. On her way home, Makoto is ejected into a railroad crossing when the brakes on her bicycle fail and is hit by an oncoming train, but finds herself transported back to the point in time when she was riding her bicycle right before the accident. After entering the Tokyo National Museum to meet with Kazuko Yoshiyama, she explains to Makoto that she has the power to \"time-leap\", to literally leap through time. At first, Makoto uses her powers to avoid being late, getting perfect grades, and even relive a single karaoke session for several hours, but soon discovers that her actions can adversely affect others.\n" +
                                                    "\n" +
                                                    "Consequently, Makoto uses most of her leaps frivolously, to prevent undesirable situations from happening, including an awkward love confession from her best friend Chiaki Mamiya. Makoto realizes that she has a numbered tattoo on her arm indicating the limited number of times she can time leap. Using her remaining time leaps, Makoto attempts to make things right for everyone. When Chiaki calls Makoto to ask if she has been time-leaping, she uses her final time leap to prevent Chiaki's call. In the meantime, Makoto's friend Kōsuke Tsuda and his new girlfriend, Kaho Fujitani, borrow her faulty bike. Makoto attempts to stop them, but because she had just used her final leap, she is unable to rescue them from the train.\n" +
                                                    "\n" +
                                                    "A moment later, Chiaki freezes time, telling Makoto that he is from the future. He explains that the walnut-shaped object is a time-traveling device, and he used it to leap through time hoping to see a painting that is being restored by Kazuko, as it has been destroyed in the future. While walking with Makoto in the frozen city, Chiaki also explains why he stayed longer in her time frame than he originally planned. Consequently, he has used his final leap to ensure Kōsuke's existence and has stopped time only to explain to Makoto what the results will be. Having revealed his origins and the nature of the item that allowed Makoto to leap through time, and now unable to return to his own time period, Chiaki must leave. Makoto then realizes that she loves him.\n" +
                                                    "\n" +
                                                    "True to his words, Chiaki disappears once time resumes. Initially distraught by Chiaki's disappearance, Makoto discovers that Chiaki's time-leap inadvertently restored her final time-leap: Chiaki had leaped back to the time before Makoto used it. Makoto uses it to safely leap back to the moment right after she originally gained her powers, at which point Chiaki still has one remaining time-leap, and recovers the used up time-travel device. Makoto explains her knowledge of everything as she shows the device to Chiaki. Makoto vows to ensure the painting's existence so Chiaki can see it in his era. Before Chiaki departs, he tells Makoto that he will be waiting for her in the future. When Kōsuke asks her where Chiaki went, she says that he went to study abroad, and that she made a decision about her own future. "),
                                    new Movies(3, "Wolf Children\n(Ōkami Kodomo no Ame to Yuki)", 2002, R.drawable.wolf,
                                            "In Tokyo, Japan, college student Hana falls in love with an enigmatic man. One night, the man reveals that he can transform into a wolf, and they later have two wolf children: a daughter, Yuki, year later a son, Ame. Soon after, their father is killed in an accident while hunting food for the children.\n" +
                                                    "\n" +
                                                    "Hana's life as a single mother is difficult; Yuki and Ame constantly switch between their human and wolf forms, and Hana has to hide them from the world. After she receives noise complaints and a visit from social workers concerned that the children have not had vaccinations, Hana moves the family to the countryside away from prying neighbors. She works hard to repair a dilapidated house, but struggles to sustain the family on their own crops. With help from a strict old man named Nirasaki, she learns to farm sufficiently, and she becomes friends with some of the locals.\n" +
                                                    "\n" +
                                                    "One winter day, Ame almost drowns in a river after trying to hunt a Kingfisher, but Yuki rescues him, and Ame becomes more confident in his abilities as a wolf. Yuki begs her mother to let her go to school like other children. Hana accepts on the condition that Yuki keeps her wolf nature secret. Though Yuki's classmates find her strange at first, she soon makes friends. However, Ame is more interested in the forest and takes lessons from an elderly fox about survival in the wild.\n" +
                                                    "\n" +
                                                    "In fourth grade, Yuki's class receives a new transfer student, Souhei, who realizes something is strange about her. When he pursues her, Yuki gets angry, transforms into a wolf, and inadvertently injures him, leaving a scar on his ear. At the meeting with their parents and teachers, Souhei tells them a wolf attacked him, absolving Yuki of the blame. The two become friends.\n" +
                                                    "\n" +
                                                    "Yuki and Ame fight over whether they are human or wolf. Two years later, a fierce storm gathers and Yuki's school is let out early. As Hana is about to leave to pick her up, Ame disappears into the forest to help his dying fox teacher, so she follows him. The other children are picked up from school by their parents, leaving Yuki and Souhei alone. After walking around the school and contemplating their futures, Yuki shows Souhei that she can transform into a wolf and that it was really her who attacked him. He tells her that he already knew, and promises to keep her secret.\n" +
                                                    "\n" +
                                                    "As Hana searches the forest for Ame, she slips and falls unconscious. While unconscious, Hana sees a vision of the children's father, who tells her that Yuki and Ame will find their own paths in life, and that she raised them well. Ame finds Hana and carries her to safety. She awakens to see Ame fully transform into a wolf and run into the mountains. She realizes he has found his own path and happily but tearfully accepts his goodbye.\n" +
                                                    "\n" +
                                                    "One year later, Yuki leaves home to move into a junior high school dormitory. Ame's wolf howls are heard far and wide in the forest. Hana, living alone in the house, reflects that raising her wolf children was like a fairy tale, and feels proud to have raised them well. ")
                            )
                    )),
                    new Studios(1, "Studio Ghibli, Inc.", "Tokyo (Japan)", 1985, R.drawable.ghibli, new ArrayList<Movies> (
                            Arrays.asList(
                                    new Movies(0, "Spirited Away\n(Sen to Chihiro no Kamikakushi)", 2001, R.drawable.chihiro,
                                            "Ten-year-old Chihiro Ogino and her parents are traveling to their new home when her father takes a wrong turn. They unknowingly enter a magical world that Chihiro's father insists on exploring. While Chihiro's parents begin to devour the food at an empty restaurant stall, Chihiro finds an exquisite bathhouse and meets a young boy named Haku who warns her to return across the river before sunset. However, Chihiro discovers too late that her parents have turned into pigs and she is unable to cross the flooded river, becoming trapped in the spirit world.\n" +
                                                    "\n" +
                                                    "Haku finds Chihiro and has her ask for a job from the bathhouse's boiler-man, Kamaji, a yōkai commanding the susuwatari. Kamaji refuses work for her and asks the worker Lin to send Chihiro to the witch, Yubaba, who runs the bathhouse. Yubaba tries to frighten Chihiro away, but she persists, so Yubaba gives Chihiro a contract to work for her. Yubaba takes her name and renames her Sen (千). After a night's rest, Haku awakens Sen and takes her to her parents' pigpen; Haku returns Sen's belongings to her along with the goodbye card addressed to Chihiro and realizes that she has already forgotten her name. Haku warns her that Yubaba controls people by taking their names and that if she forgets hers like he has forgotten his, she will not be able to leave the spirit world. When Haku leaves her after giving her some onigiri, she turns away but then when turning back sees a dragon flying off into distant sky, Sen then deduces that Haku is the dragon.\n" +
                                                    "\n" +
                                                    "Sen faces discrimination from the other workers because she is still a human and not a spirit. While working, she invites a silent masked creature named No-Face inside, believing him to be a customer. A 'stink spirit' arrives as Sen's first customer, and she discovers he is the spirit of a polluted river. In gratitude for cleaning him, he gives Sen a magic emetic dumpling. Meanwhile, No-Face tempts a worker with gold, then swallows him. He demands food and begins tipping extensively. As the workers swarm him, hoping to be tipped, he swallows two other greedy workers.\n" +
                                                    "\n" +
                                                    "Sen discovers paper shikigami attacking a Japanese dragon and recognizes the dragon as Haku transformed. When a grievously injured Haku crashes into Yubaba's penthouse, Sen follows him upstairs. A shikigami that stowed away on her back transforms into Zeniba, Yubaba's twin sister. She transforms Yubaba's baby son, Boh, into a mouse, creates a decoy baby and turns Yubaba's harpy into a tiny bird. Zeniba tells Sen that Haku has stolen a magic golden seal from her, and warns Sen that it carries a deadly curse. After destroying the shikigami, Haku falls into the boiler room with Sen, Boh and the bird on his back, where Sen feeds him part of the dumpling with which she intended to save her parents, causing him to vomit both the seal and a black slug, which Sen crushes with her foot at Kamaji's command.\n" +
                                                    "\n" +
                                                    "With Haku unconscious, Sen resolves to return the seal and apologize for Haku, but the only way to get there is by the train. Kamaji digs through his clutter and gives Sen four train tickets he saved for half a century, and warns Sen to make sure and get off at the right stop or she will be lost. Sen goes to confronts No-Face after being found by Lin, who is now massive and feeds him the rest of the dumpling. No-Face chases Sen out of the bathhouse, steadily regurgitating everything he has eaten. Sen, Boh, the bird and No-Face travel to see Zeniba. Yubaba orders that Sen's parents be slaughtered, but Haku reveals that Boh is missing, and offers to retrieve him if Yubaba releases Sen and her parents. Yubaba agrees, but only if Sen can pass a final test.\n" +
                                                    "\n" +
                                                    "Sen meets with the now benevolent Zeniba, who reveals that Sen's love for Haku broke her curse and that Yubaba used the black slug to control Haku. Haku appears at Zeniba's home in his dragon form and flies Sen, Boh and the bird to the bathhouse. No-Face decides to stay behind and becomes Zeniba's spinner. In midflight, Sen recalls falling in her youth into the Kohaku River and being washed safely ashore, thus revealing Haku's real identity as the spirit of the Kohaku River. Haku, now Kohaku Ryu (River/Dragon) remembers how he saved Sen when she fell into the water, and Sen explains that his river is no more as it was filled up by humans and where buildings now stand, the two embrace over their past connection and fly off towards the bathhouse. When they arrive at the bathhouse, Yubaba forces Sen to identify her parents from among a group of pigs in order to break their curse. After Sen answers that none of the pigs are her parents, her contract combusts and she is given back her real name. Haku takes her to the now dry riverbed and vows to meet her again. Chihiro crosses the riverbed to her restored parents, who do not remember anything. They quietly walk back to their car, which is now covered in dust and leaves. Before getting in, Chihiro takes a last look back. Her father then says that moving to a new town, a new house, and meeting new people can be scary, but Chihiro says she'll be okay. "),
                                    new Movies(1, "Princess Mononoke\n(Mononoke-hime)", 1997, R.drawable.mononoke,
                                            "In Muromachi Japan, an Emishi village is attacked by a demon. The last Emishi prince, Ashitaka, kills it before it reaches the village, but its corruption curses his right arm. The curse gives him superhuman strength, but will eventually spread through his body and kill him. The villagers discover that the demon was a boar god, Nago, corrupted by an iron ball lodged in his body. The village's wise woman tells Ashitaka that he may find a cure in the western lands Nago came from, but he cannot return to his homeland.\n" +
                                                    "\n" +
                                                    "Heading west, Ashitaka meets Jigo (\"Jiko-bō\" in the original Japanese version), an opportunist Buddhist monk, who tells Ashitaka he may find help from the Great Forest Spirit, a deer-like animal god by day and a giant \"nightwalker\" by night. Nearby, men herd oxen to Irontown (\"Tataraba\" in Japanese), led by Lady Eboshi, and repel an attack by a wolf pack led by the wolf goddess Moro. Riding one of the wolves is San, a human girl. Ashitaka discovers two injured Irontown men and carries them through the forest, where he encounters many kodama and glimpses the Forest Spirit. In Irontown, Ashitaka learns that Eboshi built the town by clearcutting forests to claim ironsand and produce iron, leading to conflicts with the forest gods and Asano, a local daimyō. Irontown is a refuge for social outcasts, including lepers employed to manufacture firearms; it was one of these guns that had wounded Nago. Eboshi also explains that San was raised by the wolves as one of their own and resents humankind.\n" +
                                                    "\n" +
                                                    "San infiltrates Irontown to kill Eboshi, but Ashitaka intervenes, knocking them both unconscious. As he leaves, he is \"accidentally\" shot by a villager, but the curse gives him the strength to carry San out of the village. San awakens and prepares to kill the weakened Ashitaka, but hesitates when he tells her that she is beautiful. She takes him to the forest, and decides to trust him after the Forest Spirit saves his life. A boar clan, led by the blind boar god Okkoto, plans to attack Irontown to save the forest. Eboshi prepares for battle and sets out to kill the Forest Spirit with Jigo, who is working for the government; she intends to give the god's head to the Emperor in return for protection from Lord Asano. According to legend, the Forest Spirit's head grants immortality.\n" +
                                                    "\n" +
                                                    "Ashitaka recovers from his wound but remains cursed; he returns to Irontown to find it besieged by samurai, and heads out to warn Eboshi. The boar clan is annihilated in battle, and Okkoto is corrupted by his wounds. Jigo's men disguise themselves in boar skins and trick the rampaging Okkoto into leading them to the Forest Spirit. San tries to stop Okkoto, but is swept up in his demonic corruption. Moro intervenes and Ashitaka dives into the corruption, saving San. The Forest Spirit euthanizes Okkoto and Moro. As it transforms into the nightwalker, Eboshi decapitates it. It bleeds ooze which spreads over the land, killing anything it touches as the nightwalker searches for its head, which Jigo steals. The forest and kodama begin to die; Moro's head comes alive and bites off Eboshi's right arm, but she survives.\n" +
                                                    "\n" +
                                                    "After the samurai flee and Irontown is evacuated, Ashitaka and San pursue Jigo and retrieve the head, returning it to the Forest Spirit. The Spirit dies as the sun rises, but its form washes over the land and heals it, and Ashitaka's curse is lifted. Ashitaka stays to help rebuild Irontown, but promises San he will visit her in the forest. Eboshi reunites with the townspeople and vows to build a better town. The forest begins to regrow, and a kodama emerges from the undergrowth. "),
                                    new Movies(2, "My Neighbor Totoro\n(Tonari no Totoro)", 1988, R.drawable.totoro,
                                            "In 1958 Japan, university professor Tatsuo Kusakabe and his two daughters, Satsuki and Mei, move into an old house to be closer to the hospital where the girls' mother, Yasuko, is recovering from a long-term illness. Satsuki and Mei find that the house is inhabited by tiny creatures called susuwatari—small, dark, dust-like house spirits seen when moving from light to dark places. When the girls become comfortable in their new house and laugh with Tatsuo, the soot spirits leave the house to drift away on the wind and find another empty house.\n" +
                                                    "\n" +
                                                    "One day, Mei sees two white, rabbit-like ears in the grass and follows the ears under the house. She discovers two small spirits who lead her through a briar patch and into the hollow of a large camphor tree. She meets and befriends a larger version of the same kind of spirit, which identifies itself by a series of roars that she interprets as \"Totoro\". She falls asleep atop the large totoro, but when Satsuki finds her, she is on the ground in a dense briar clearing. Despite her many attempts, Mei is unable to show her family Totoro's tree. Tatsuo comforts her by telling her that this is the \"keeper of the forest,\" and that Totoro will reveal himself when he wants to.\n" +
                                                    "\n" +
                                                    "One rainy night, the girls are waiting for Tatsuo's bus and grow worried when he doesn't arrive on the bus they expect him on. As they wait, Mei eventually falls asleep on Satsuki's back and Totoro appears beside them, allowing Satsuki to see him for the first time. He has only a leaf on his head for protection against the rain, so Satsuki offers him the umbrella she had taken along for her father. Totoro is delighted at both the shelter and the sounds made upon it by falling raindrops. In return, he gives her a bundle of nuts and seeds. A giant, bus-shaped cat halts at the stop, and Totoro boards it, taking the umbrella. Shortly after, Tatsuo's bus arrives.\n" +
                                                    "\n" +
                                                    "The girls plant the seeds. A few days later, they awaken at midnight to find Totoro and his two miniature colleagues engaged in a ceremonial dance around the planted nuts and seeds. The girls join in, whereupon the seeds sprout, and then grow and combine into an enormous tree. Totoro takes his colleagues and the girls for a ride on a magical flying top. In the morning, the tree is gone, but the seeds have indeed sprouted; it is left unclear whether or not the girls were dreaming.\n" +
                                                    "\n" +
                                                    "The girls find out that a planned visit by Yasuko has to be postponed because of a setback in her treatment. Satsuki, disappointed and worried, tells Mei the bad news, which Mei does not take well. This leads to an argument between the two, ending in Satsuki yelling at Mei and stomping off. Mei decides to walk to the hospital to bring some fresh corn to Yasuko.\n" +
                                                    "\n" +
                                                    "Mei's disappearance prompts Satsuki and the neighbors to search for her. Eventually, Satsuki returns in desperation to the camphor tree and pleads for Totoro's help. Delighted to be of assistance, he summons the Catbus, which carries her to where the lost Mei sits. Having rescued her, the Catbus then whisks her and Satsuki over the countryside to see Yasuko in the hospital. The girls perch in a tree outside of the hospital, overhearing a conversation between their parents and discovering that she has been kept in hospital by a minor cold, but is otherwise doing well. They secretly leave the ear of corn on the windowsill, where it is discovered by the parents, and return home on the Catbus.\n" +
                                                    "\n" +
                                                    "Eventually, Mei and Satsuki's mother returns home, and the sisters play with other children, while Totoro and his friends watch them from afar. "),
                                    new Movies(3, "Porco Rosso", 1992, R.drawable.porco,
                                            "Porco Rosso, an Italian veteran World War I fighter ace and freelance bounty hunter, fends off an attack on a ferry liner by airborne pirates. Porco treats himself to dinner at the Hotel Adriano, which is run by his friend Gina.\n" +
                                                    "\n" +
                                                    "At the hotel, the heads of the pirate gangs are contracting Curtis, an arrogant and ambitious American ace, to assist them in their next attacks. Curtis falls in love with Gina on the spot, but is frustrated to see his declarations rebuffed and her affection for Porco. After successfully executing a pirating mission, Curtis tracks down Porco, who is flying to Turin (Milan in the English language version) to have his plane serviced, and shoots him down as he experiences an engine outage, claiming to have killed him. Porco survives, though his plane is heavily damaged. Porco continues the trip by train with the remains of the plane, much to the irritation of Gina, who reminds him that there is a warrant for his arrest in Italy.\n" +
                                                    "\n" +
                                                    "Porco arrives discreetly in Turin to meet Piccolo, his mechanic. He learns that Piccolo's sons have emigrated to find work elsewhere due to the Great Depression, and much of the engineering will have to be carried on by his young granddaughter Fio. Porco is initially skeptical of Fio's abilities as a mechanic, but after seeing her dedication in the repair project he accepts her as a competent engineer. Once Porco's plane is finished, Fio joins him on his flight home, with the justification that if the secret police arrest the team, they can say that Porco forced them to help and took Fio as a hostage. Stopping off to refuel on the way, Porco discovers that the new fascist government is beginning to hire seaplane pirates for their own use, thus putting him out of business.\n" +
                                                    "\n" +
                                                    "Back at the Hotel Adriano, Curtis proposes to Gina but she turns him down, saying that she is waiting for Porco Rosso. Upon returning home, Porco and Fio are ambushed by the pirates, who threaten to kill Porco and destroy his plane. Fio talks them out of it, but Curtis appears and challenges Porco to a final duel. Fio makes a deal with him declaring that if Porco wins, Curtis must pay off his debts owed to Piccolo's company, and if Curtis wins, he may marry her.\n" +
                                                    "\n" +
                                                    "That night, Porco tells a story from World War I. His entire squadron apart from himself was shot down in a dogfight with Austro-Hungarian aircraft. He recalls blacking out and awakening to find himself in complete stillness, with a white band hovering in the distant sky. Allied and enemy aircraft, flown by the airmen who died in the dogfight, fly past towards the band but ignore him. Porco soon sees that the band is in fact thousands of planes flying together. He blacks out again, and awakens flying low over the sea, alone.\n" +
                                                    "\n" +
                                                    "The next day, the duel is arranged and a large crowd gathers to observe. The indecisive and long dogfight between Porco and Curtis soon dissolves into a bare-knuckle boxing match when both planes' machine guns jam. Gina appears and warns the crowd that the Italian air force has been alerted and are on their way. Porco barely wins the fight upon her arrival, and hands Fio over to Gina, requesting that she look after Fio. Before the plane takes off, Fio gives Porco a kiss. With the crowd gone, Porco and Curtis agree to delay the air force together. When Curtis sees Porco's face, he reacts with surprise (implying that the pig curse has been lifted). Fio narrates that in the end Porco outflies the Italian air force and is never hunted by them again; Fio herself became president of the Piccolo company, which is now an aircraft manufacturer; Curtis became a famous actor; and the pirates continued to attend the Hotel Adriano in their old age. She does not divulge whether Gina's hope about Porco Rosso was ever realized.\n" +
                                                    "\n" +
                                                    "After the credits, a familiar red seaplane appears soaring in the sky before disappearing into the clouds. ")
                            )
                    )),
                    new Studios(2, "CoMix Wave Films", "Tokyo (Japan)", 2007, R.drawable.comix, new ArrayList<Movies> (
                            Arrays.asList(
                                    new Movies(0, "Your Name\n(Kimi no Na wa)", 2016, R.drawable.nawa,
                                            "High school girl Mitsuha Miyamizu lives in the town of Itomori in Japan's mountainous Hida region. She is bored with the country life, and wishes to be a handsome boy in her next life. She begins switching bodies intermittently with Taki Tachibana, a high school boy in Tokyo when they wake up. They communicate by writing messages on paper, their phones, and sometimes on each other's skin. Mitsuha causes Taki to develop a relationship with his coworker Miki, while Taki causes Mitsuha to become popular in school.\n" +
                                                    "\n" +
                                                    "One day, Taki, as Mitsuha, accompanies her grandmother and sister to leave the ritual alcohol kuchikamizake, made by Mitsuha, as an offering at the shrine on a mountaintop outside the town. The shrine is believed to represent the body of the village guardian god who rules human experiences and connections. Mitsuha's latest note tells Taki about a comet expected to pass Earth on the day of her town festival.\n" +
                                                    "\n" +
                                                    "Next day, Taki wakes up in his body. After an unsuccessful date with Miki, he tries to call Mitsuha, but cannot reach her, and the body switching ends. He decides to visit Itomori, but does not know its name, his memories of it are fading, and Mitsuha's messages have disappeared. A restaurant owner in Hida finally recognizes Itomori from Taki's sketch and tells him when the comet unexpectedly split into two, the larger piece kept moving, but the smaller one crashed onto Earth and destroyed the town. Taki finds Mitsuha's name in the records of fatalities and discovers the date of the disaster, realizing their timelines were separated by three years.\n" +
                                                    "\n" +
                                                    "Taki goes to the shrine to drink Mitsuha's kuchikamizake, hoping to reconnect with her body and warn her of the comet strike. Through a vision, Taki discovers that Mitsuha, having fallen in love with him, met his past self while trying to meet him personally. He wakes in her body on the morning of the town festival; Mitsuha's grandmother deduces his identity, and tells him the body switching is part of the Miyamizu family history as caretakers of the shrine. He convinces Mitsuha's friends Tessie and Sayaka to help evacuate the town by cutting the power and broadcasting a false emergency alert, but the plan fails. He realizes that Mitsuha must be in his body at the shrine and goes back to find her.\n" +
                                                    "\n" +
                                                    "Mitsuha wakes up in Taki's body at the shrine. When Taki reaches the shrine as the sun sets they sense each other's presence, but are separated by three years. However, when twilight falls, they return to their own bodies and meet. They attempt to write each other's names on their hands so they will remember each other, but twilight passes and Mitsuha disappears before she can write hers.\n" +
                                                    "\n" +
                                                    "As Mitsuha races back to town to convince her estranged father, the Itomori mayor, to evacuate the town, her memories of Taki start to fade. She realizes that Taki wrote \"I love you\" on her hand instead of his name. The comet piece crashes to Earth, destroying Itomori. Taki wakes up in his own time at the shrine, remembering nothing.\n" +
                                                    "\n" +
                                                    "Five years later, Taki has graduated from university and is searching for a job. He senses he is missing something important and learns that inhabitants of Itomori survived by following the mayor's order. One day, Taki and Mitsuha see each other when their trains draw parallel, and are compelled to disembark and search for one another, finally meeting on a staircase. Feeling they have met before, they simultaneously ask for each other's name. "),
                                    new Movies(1, "The Garden of Words\n(Koto no ha no Niwa)", 2013, R.drawable.garden,
                                            "It opens at the start of the rainy season in Tokyo with Takao Akizuki (秋月 孝雄 Akizuki Takao), a 15-year-old student and aspiring shoemaker, opting to skip his first class and sketch shoe designs in the garden at Shinjuku Gyoen. There he encounters Yukari Yukino (雪野 百香里 Yukino Yukari), a 27-year-old woman who is skipping work and enjoying beer and chocolate. When she notices the school crest on his uniform, Yukari bids him farewell with a tanka (a form of Japanese poetry), leaving Takao puzzled as to its origin and meaning. The two continue to encounter each other and socialize in the park on rainy mornings, but never formally introduce themselves. After Yukari expresses an interest in Takao's shoemaking, he decides to make a pair of shoes in her size. With the end of the rainy season, Takao stops visiting the park and focuses on his work.\n" +
                                                    "\n" +
                                                    "Following summer break, Takao returns to school and spots Yukari. His friends inform him that she is a literature teacher and that she had been the target of gossip and bullying. Out of kindness and to avoid further confrontation, Yukari opted to avoid work and retreat to the park, hoping she would learn to overcome her fears and be able to \"walk\" again. However, Yukari quits her job and leaves the school. That afternoon, Takao meets Yukari at the park and greets her by reciting the 2,514th poem from the Man'yōshū Japanese poetry collection, the correct response to her tanka, which he found in a classic Japanese literature textbook. After getting soaked by a sudden thunderstorm, both head to Yukari's apartment and spend the afternoon together. When Takao confesses his love following dinner, Yukari is visibly moved, but then reminds him that she is a teacher and tells him that she is moving back to her home town on Shikoku. After Takao abruptly excuses himself, Yukari realizes her mistake and runs after him, finding him in the stairwell. Still upset, Takao angrily takes back what he had said and criticizes her for being so secretive and never opening up to him. Yukari embraces him and the two cry while she explains that their time together in the park had saved her.\n" +
                                                    "\n" +
                                                    "The credits show Takao barely passing his final exams, but still working towards his goals, while Yukari moves back to Shikoku and resumes her teaching career. In a post-credits scene, Takao revisits the park that winter, reads a letter from Yukari, places her finished shoes on the bench and then vows that he will find her after he has made progress with his career.\n" +
                                                    "\n" +
                                                    "In the manga illustrated by Midori Motohashi, scenes were either added or slightly modified from the anime version. For example, after the conclusion of the rainy season, Takao was unable to visit the park during the only rainy morning that summer because he had scheduled to visit the footwear college he wanted to attend, disappointing Yukari who had hoped to see him in the park. Also, at the conclusion of the story, Yukari is seen wearing the shoes Takao had made for her."),
                                    new Movies(2, "5 Centimeters per Second\n(Byousoku 5 Centimeter)", 2007, R.drawable.cm,
                                            "Takaki Toono and Akari Shinohara, two very close friends and classmates, are torn apart when Akari's family is transferred to another region of Japan due to her family's job. Despite separation, they continue to keep in touch through mail. When Takaki finds out that his family is also moving, he decides to meet with Akari one last time.\n" +
                                                    "\n" +
                                                    "As years pass by, they continue down their own paths, their distance slowly growing wider and their contact with one another fades. Yet, they keep remembering one another and the times they have shared together, wondering if they will have the chance to meet once again."),
                                    new Movies(3, "Children Who Chase Lost Voices\n(Hoshi wo Ou Kodomo)", 2011, R.drawable.voices,
                                            "Asuna Watase is a young elementary school girl who has been forced to grow up quickly ever since her father had died, while her mother, a nurse, works long shifts at a hospital. Asuna spends her solitary days listening to the mysterious music emanating from the cat's-whisker receiver her father gave to her as a memento, accompanied by pet cat Mimi, who bears strange red markings on her fur.\n" +
                                                    "\n" +
                                                    "One day, while walking to her clubhouse across a bridge, she is attacked by a fearsome creature and saved by a mysterious teenage boy who calls himself Shun. Asuna treats Shun's wound from fighting the creature and later they both listen to Asuna's radio. Shun tells Asuna he is from another country called Agartha and that he came to this place to find something. He then gives Asuna a blessing in the form of a kiss to the forehead. Asuna leaves hurriedly and tells Shun she'll be back tomorrow. Shun, now alone, looks up at the stars and falls from the ledge to his death.\n" +
                                                    "\n" +
                                                    "The next morning, Asuna hears from her mother that a boy was found dead in the river, but refuses to believe it's Shun. In school, Mr. Morisaki, a substitute teacher, is giving a lecture on a book which grabs Asuna's attention when he mentions Agartha, the land of the dead. After school, she visits Morisaki and asks him about Agartha. Morisaki explains that long ago when humankind was young, it needed the guidance of Quetzalcoatls, keepers of the dead, until humans matured and no longer needed them. They went underground along with a few humans who joined them.\n" +
                                                    "\n" +
                                                    "Afterwards, Asuna goes to her hideout to find another mysterious boy who looks like Shun standing on the ledge. Just then, a group of armed men called the Arch Angels appear, and attack the both of them. The mysterious boy hides in the underground entrance with Asuna, and the two proceed further into the cave when the cave's entrance is bombed. The two meet a Quetzacoatl who has apparently lost its physical senses and attacks the boy. He refuses to kill the gatekeeper, giving Asuna his clavis, a crystal, and fights back. The Arch Angels interfere, killing the gatekeeper. The Arch Angel commander captures Asuna and uses the clavis to open a gateway to Agartha. The commander and Asuna enter the gateway followed by the boy. Once inside the commander reveals himself to be Morisaki and the boy also reveals himself to be Shin, Shun's younger brother. Morisaki tells Shin that all he wants is to bring back his late wife from the dead. Shin leaves Asuna and Morisaki.\n" +
                                                    "\n" +
                                                    "Morisaki tells Asuna that she can go back but she decides to accompany him. They both go into the realm via an underwater entrance. Once inside, they journey to the Gate of Life and Death which can bring the souls of people back from the dead, along with Mimi (who had snuck inside Asuna's backpack).\n" +
                                                    "\n" +
                                                    "Upon arriving in his village, Shin is told he failed his mission to retrieve the clavis, because Asuna has unknowingly returned with a fragment of one. Shin re-embarks to stop Asuna and Morisaki from wreaking havoc in Agartha.\n" +
                                                    "\n" +
                                                    "Along the way, Asuna is kidnapped by a race of monsters called the Izoku. She awakens in a closed area and meets a young girl named Manna; they both try to escape but are not able to. The day begins to darken and the Izoku begin to appear, but they can only move in the shadows. In their escape attempt they encounter Shin, who helps them but is wounded by an Izoku during the escape. Morisaki finds Asuna and Manna down the river as well as Shin with the help of Mimi. Shin tries to retrieve the clavis crystal fragment that belongs to Asuna. However, he is too weak to put up a fight and Morisaki easily defeats him. Asuna convinces Morisaki to take him with them while Manna leads them to her village.\n" +
                                                    "\n" +
                                                    "Once there, the villagers are at first reluctant to help the \"top-dwellers\" but the village elder convinces the guards to let them in. The elder allows them to stay one night at the village because they have brought Manna back but they cannot stay more than that due to past history in that top-dwellers always bring bad luck to Agartha. Meanwhile, Asuna checks up on Shin but he yells at her to leave him alone.\n" +
                                                    "\n" +
                                                    "The next morning, Asuna and Morisaki depart from Amaurot by boat, but Mimi no longer wants to accompany them. Shin wakes up later and finds that Mimi has passed; Shin, Manna, and the elder proceed to offer Mimi's corpse to the Quetzacoatl. When Shin sees the villagers riding away to kill them, he decides to follow, in order to protect Asuna. Morisaki and Asuna are walking towards a steep cliff when they are attacked by the villagers but they are saved by Shin. Asuna tries to climb down but is too scared, while Morisaki continues on, after trading his gun for her clavis shard and telling her to go back to the surface.\n" +
                                                    "\n" +
                                                    "Meanwhile, Shin is fighting the villagers and is about to be killed when the villagers sense that the clavis crystal has reached the Gate of Life and Death. They leave Shin to let him wander aimlessly, having betrayed his country.\n" +
                                                    "\n" +
                                                    "Asuna, following Morisaki's instructions to stay in the water during nighttime because of the Izoku, walks aimlessly and asks herself why she came to Agartha; she finally accepts that she came to Agartha because she was feeling lonely. When the water dries up, she is attacked by the Izoku but is saved by Shin again. The two return to the cliff after seeing the Ark of Life descending. They encounter a Quetzalcoatl who is about to die. Before he dies, the Quetzalcoatl sings its song to send all its memories into the world; Asuna now understands that the last song she heard in her world was Shun's song before he was to die. The Quetzacoatl offers to take them to the bottom of the cliff.\n" +
                                                    "\n" +
                                                    "At the bottom of the cliff, they both find the Gate of Life and Death and enter it. Morisaki has already made a wish for his late wife Lisa to return, however, her soul requires a vessel. Asuna and Shin find Morisaki, who tells Asuna she shouldn't have come; she is soon possessed by the soul of Morisaki’s wife. But this price is insufficient; Morisaki also pays with the loss of an eye. To undo Asuna’s possession, Shin destroys the clavis crystal, despite Morisaki having a knife to his throat. Breaking the clavis brings Asuna's soul back to her body, after she has had a short reunion with Mimi and Shun. Before Lisa leaves Asuna's body, she tells Morisaki to find happiness without her. Asuna is now back to her normal self but Morisaki is devastated and asks Shin to kill him. Shin tells him that carrying the burden of a deceased loved one is humanity's curse, telling Morisaki to live on. Asuna heads back to the surface and is seen making her farewell to Shin and Morisaki, who chose to stay behind. The film ends with an older Asuna looking out her window at the cliff side where she had met Shun and Shin. She then says her goodbyes to her mother as she hurries to her graduation ceremony. ")
                            )
                    ))
            )
    );

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_spinner, container, false);
        studios = (Spinner) view.findViewById(R.id.studios);
        works = (Spinner) view.findViewById(R.id.works);

        studios.setAdapter(new StudioAdapter(getActivity(), autores));

        studios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                works.setAdapter(new WorkAdapter(getActivity(), autores.get(position).getMovies()));

                final ArrayList<Movies> obras = autores.get(position).getMovies();

                works.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                        MainActivity.description = obras.get(position).getDescription();

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.description, new DescFragment()).addToBackStack(null).commit();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
        return view;
    }
}

class StudioAdapter extends ArrayAdapter {

    public StudioAdapter(Context context, ArrayList<Studios> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.linear_spinner_studio, parent, false
            );
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView country = convertView.findViewById(R.id.country);
        TextView founded = convertView.findViewById(R.id.founded);
        TextView moviesCount = convertView.findViewById(R.id.works_quantity);
        ImageView autor = convertView.findViewById(R.id.image);

        Studios currentItem = (Studios) getItem(position);

        if (currentItem != null) {
            name.setText("Name: " + currentItem.getName());
            country.setText("Country: " + currentItem.getCountry());
            founded.setText("Foundation Year: " + currentItem.getFounded());
            moviesCount.setText("Movies Count: " + currentItem.getMovies().size());
            autor.setImageResource(currentItem.getImage());
        }

        return convertView;
    }
}

class WorkAdapter extends ArrayAdapter {

    public WorkAdapter(Context context, ArrayList<Movies> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.linear_spinner_movie, parent, false
            );
        }

        TextView name = convertView.findViewById(R.id.title);
        name.setSingleLine(false);
        TextView year = convertView.findViewById(R.id.year);
        ImageView poster = convertView.findViewById(R.id.image);

        Movies currentItem = (Movies) getItem(position);

        if (currentItem != null) {
            name.setText("Title: " + currentItem.getTitle());
            year.setText("Year: " + currentItem.getYear());
            poster.setImageResource(currentItem.getImage());
        }

        return convertView;
    }
}
