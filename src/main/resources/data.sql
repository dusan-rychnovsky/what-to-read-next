---
--- ANDRZEJ SAPKOWSKI                                                        
---

INSERT INTO Authors (firstname, lastname)
VALUES ('Andrzej', 'Sapkowski');

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Zaklínač I: Poslední přání',
	'Zaklínač… Ošlehaný muž bez věku, jehož bílé vlasy nejsou znakem stáří, ale mutace, kterou musel podstoupit. Placený i dobrovolný likvidátor prapodivných tvorů: mantichor, trollů, vidlohonů, strig, amfisbain – pokud ovšem ohrožují lidský rod; v takovém případě zabíjí i bytost zvanou člověk. Prvotřídní, skvělý bojovník, který není neporazitelný ani nezranitelný – naopak, téměř z každého dobrodružství si odnáší další šrámy na těle i na duši. Nově přeložené geraltovské povídky ze Stříbrného meče, něco z Věčného ohně a Meče osudu + kompletní povídka Hlas rozumu kde Geralt vysvětluje, jak to všechno začalo.',
	'http://obalky.kosmas.cz/ArticleCovers/158941_big.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Sapkowski'),
	(SELECT bookId FROM Books WHERE title = 'Zaklínač I: Poslední přání')
);

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Zaklínač II: Meč osudu',
	'Hlavním hrdinou tvorby Andrzeje Sapkowského je zaklínač Geralt z Rivie. Jako nájemný hubitel upírů, vlkodlaků a všemožných nebezpečných netvorů pochopitelně ovládá bojové a magické techniky nezbytné pro jeho zaměstnání. Nicméně není pouze chladnokrevným profesionálem a už vůbec ne jedním ze superhrdinů, jimiž se žánr fantasy jen hemží. Postupně vychází najevo, že neměl možnost si svůj osud svobodně zvolit, ale naopak je nucen draze platit za schopnosti a dovednosti nedosažitelné a vesměs též nepochopitelné běžným smrtelníkům. Proto vyvolává strach a zároveň nevraživost a odpor těch, jejichž životy vlastně chrání. Přes své pozitivní působení jsou zaklínači odsouzeni k vyhnanství na samém okraji společnosti, která sice působí vnějškově středověkým dojmem, avšak s mnoha atributy převzatými ze současnosti.',
	'http://obalky.kosmas.cz/ArticleCovers/159780_big.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Sapkowski'),
	(SELECT bookId FROM Books WHERE title = 'Zaklínač II: Meč osudu')
);

---
--- JOHN TOLKIEN
---

INSERT INTO Authors (firstname, lastname)
VALUES ('John', 'Tolkien');

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Hobit',
	'Toto je příběh o tom, kterak se Pytlík vydal za dobrodružstvím a shledal, že náhle dělá a říká naprosto neočekávané věci… Bilbo Pytlík je hobit, který se těší z pohodlnéh a skromného života a jen zřídkakdy putuje dále než do své spižírny ve Dně pytle. Jeho spokojené bytí je však narušeno, když se jednoho dne u jeho prahu objeví čaroděj Gandalf v doprovodu třinácti trpaslíků a vezmou ho s sebou na cestu "tam a zase zpátky". Mají v úmyslu uloupit poklad mocného Šmaka, velikého a velmi nebezpečného draka...',
	'http://obalky.kosmas.cz/ArticleCovers/175421_big.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Tolkien'),
	(SELECT bookId FROM Books WHERE title = 'Hobit')
);

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Pán prstenů I - Společenstvo prstenu',
	'V dávných dobách vykovali elfští kováři prsteny moci, netušili však, že Temný pán Sauron dal vyrobit ještě Jeden prsten, který měl vládnout všem. Spojené armády lidí a elfů nakonec Saurona porazily a prsten mu odňaly, tato magická věc se však ztratila, aby po mnoha letech padla do rukou Bilba Pytlíka. Trilogie Pán prstenů vypráví o nebezpečné cestě Bilbova příbuzného Froda, který musí opustit ospalou vesničku Hobitín v Kraji a vydat se na nebezpečnou cestu přes celou Středozem k Puklinám osudu, aby zničil Prsten, a zmařil tak Sauronovy temné plány.',
	'http://obalky.kosmas.cz/ArticleCovers/129856_big.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Tolkien'),
	(SELECT bookId FROM Books WHERE title = 'Pán prstenů I - Společenstvo prstenu')
);

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Pán prstenů II - Dvě věže',
	'V dávných dobách vykovali elfští kováři prsteny moci, netušili však, že Temný pán Sauron dal vyrobit ještě Jeden prsten, který měl vládnout všem. Spojené armády lidí a elfů nakonec Saurona porazily a prsten mu odňaly, tato magická věc se však ztratila, aby po mnoha letech padla do rukou Bilba Pytlíka. Trilogie Pán prstenů vypráví o nebezpečné cestě Bilbova příbuzného Froda, který musí opustit ospalou vesničku Hobitín v Kraji a vydat se na nebezpečnou cestu přes celou Středozem k Puklinám osudu, aby zničil Prsten, a zmařil tak Sauronovy temné plány.',
	'http://obalky.kosmas.cz/ArticleCovers/130372_big.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Tolkien'),
	(SELECT bookId FROM Books WHERE title = 'Pán prstenů II - Dvě věže')
);

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Pán prstenů III - Návrat krále',
	'V dávných dobách vykovali elfští kováři prsteny moci, netušili však, že Temný pán Sauron dal vyrobit ještě Jeden prsten, který měl vládnout všem. Spojené armády lidí a elfů nakonec Saurona porazily a prsten mu odňaly, tato magická věc se však ztratila, aby po mnoha letech padla do rukou Bilba Pytlíka. Trilogie Pán prstenů vypráví o nebezpečné cestě Bilbova příbuzného Froda, který musí opustit ospalou vesničku Hobitín v Kraji a vydat se na nebezpečnou cestu přes celou Středozem k Puklinám osudu, aby zničil Prsten, a zmařil tak Sauronovy temné plány.',
	'http://obalky.kosmas.cz/ArticleCovers/134791_big.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Tolkien'),
	(SELECT bookId FROM Books WHERE title = 'Pán prstenů III - Návrat krále')
);

---
--- GOODKIND TERRY
---

INSERT INTO Authors (firstname, lastname)
VALUES ('Terry', 'Goodkind');

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Meč pravdy I - První čarodějovo pravidlo',
	'První čarodějovo pravidlo je román vynikajícího spisovatele fantasy. Příběh Richarda Cyphera předurčeného bojovat s protivníkem nejsilnějším – tím je Darken Rahl, zlověstný mág, který si přeje zničit všechno, co Richard považuje za dobré a krásné, a odsoudit jej spolu s ostatními obyvateli Západozemí k životu v pekle zotročení a ponížení. Richardův život se změní, když zachrání Kahlan, krásnou ženu, která zoufale prchá před Rahlovými úkladnými vrahy, když se pokouší najít Zedda, posledního velkého čaroděje. Pouze Zedd může vysvětit hledače pravdy, člověka s čistým srdcem a silnou vůlí, který bude muset vládnout strašlivou mocí, legendárního Meče pravdy....',
	'http://img.databazeknih.cz/images_books/70_/70146/prvni-carodejovo-pravidlo-70146.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Goodkind'),
	(SELECT bookId FROM Books WHERE title = 'Meč pravdy I - První čarodějovo pravidlo')
);

INSERT INTO Books (title, description, imageUrl)
VALUES (
	'Meč pravdy II - Kámen slz',
	'Richardovi Cypherovi, který porazil zlého mága Darkena Rahla, není dopřáno odpočinku. Ovládá magii, ale pouze sestry světla jej dokážou naučit poznat vlastní talent, aby mohl bojovat proti temným silám. Putuje za sestrami do starobylého Paláce proroků ve vzdálené zemi Starého světa, aby rozvinul svoji sílu a odhalil temné tajemství vlastního původu. Kahlan, poslední matka zpovědnice, vede vojska Středozemí do bitvy na život a na smrt proti Rahlově armádě démonů. Mágova msta vyprovokovala krvavou válku. Kahlan nedokáže zastavit vraždění. Poslední naději skýtá Aydindril, sídlo čarodějů. Právě do něho musí dorazit Zedd, který je posledním ze skutečných mágů, aby vyvolal mocné síly k záchraně všech zemí.',
	'http://obalky.kosmas.cz/ArticleCovers/162756_big.jpg'
);

INSERT INTO Authorship (authorId, bookId)
VALUES (
	(SELECT authorId FROM Authors WHERE lastname = 'Goodkind'),
	(SELECT bookId FROM Books WHERE title = 'Meč pravdy II - Kámen slz')
);
