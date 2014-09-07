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
