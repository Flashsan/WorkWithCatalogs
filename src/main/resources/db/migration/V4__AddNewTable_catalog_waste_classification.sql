create table catalog_waste_classification
(
    id_waste_classification                int auto_increment,
    kod_waste_classification         varchar(500),
    title_waste_classification             varchar(500),
    id_degree_of_danger      int,
    id_class_of_danger                int,
    id_kind_of_activity                 int,
    education_standard_catalog_waste_classification varchar(200),
    constraint catalog_waste_classification_pk primary key ( id_waste_classification )
);

insert into catalog_waste_classification(kod_waste_classification ,
                                         title_waste_classification,
                                         id_degree_of_danger,
                                         id_class_of_danger,
                                         id_kind_of_activity,
                                         education_standard_catalog_waste_classification)
values('3532201', 'Свинцовые аккумуляторы отработанные неповрежденные с неслитым электролитом', 1, 1, 1, 'Не задано'),
      ('3532603',	'Ртутные лампы отработанные', 1, 1, 1, 'Не задано'),
      ('3532604',	'Люминесцентные трубки отработанные', 1, 1, 1, 'Не задано'),
('3532607',	'Компактные люминесцентные лампы (энергосберегающие) отработанные',	1, 1, 1, 'Не задано'),
('1711700',	'Отходы (куски, обрезки), фанеры, древесно-стружечных плит, древесно-волокнистых плит, заготовок гнутоклееных и плоскоклееных и др.', 2, 3, 2, 'Не задано'),
('1721101',	'Опилки древесные промасленные (содержание масел – менее 15%)',	2, 3, 3, '1,15т на 1т используемых чистых опилок'),
('3130601',	'Зола от сжигания быстрорастущей древесины, зола от сжигания дров',	2, 3,4, 'Зольность топлива Аd = 1,1% на рабочую массу местных видов топлива'),
('3141204',	'Бой шифера	', 2, 3, 5, '9 кг/м2 изолируемой поверхности'),
('3142404',	'Песок, загрязненный мазутом (содержание мазута – 15% и более)', 2, 3, 6, 'Не задано'),
('3142406',	'Песок, загрязненный маслами (содержание масел – 15% и более)',	2, 3, 3, 'Не задано'),
('3143707',	'Отходы асбокартона', 2, 3,	1, 'до 3 кг/м2 изолируемой поверхности'),
('3164200',	'Шлам от чистки котлов', 2, 3, 1, 'до 0,4 кг/т топлива'),
('3531001',	'Проволока медная',	2, 3, 1, 'Не задано'),
('5410202',	'Масла моторные отработанные',	2,	3, 1, 'Не задано'),
('5412300',	'Смесь нефтепродуктов отработанных', 2,	3, 1, 'Не задано'),
('5440100',	'Средства охлаждения и смазки',	2, 3, 1, 'Не задано'),
('5471500',	'Шлам очистки емкостей', 2,	3, 1, 'Не задано'),
('5492800',	'Отработанные масляные фильтры', 2,	3, 1, '0,137 кг/10 тыс. км пробега'),
('5492900',	'Использованная тара от нефтепродуктов', 2,	3, 1, 'Не задано'),
('5551300',	'Старые лаки, краски затвердевшие, а также затвердевшие остатки в бочках (др. емкостях)', 2, 3, 7, 'Не задано'),
('5710803',	'Пенопласт полистирола', 2,	3, 8, 'Не задано'),
('5710812',	'АБС-пластик',	2,	3, 1, 'Не задано'),
('5710831',	'Вышедшие из употребления изделия и материалы из полистирола и его сополимеры',	2, 3, 1, 'Не задано'),
('5711011',	'Пенополиуретан', 2, 3, 1, '1,8 кг/м погонный заменяемой трубы'),
('5711400',	'ПЭТ-бутылки',	2,	3	,10, 'Не задано'),
('5711601',	'Поливинилхлорид',	2,	3,	1, 'Не задано'),
('5712105',	'Полиэтилен низкого давления', 2, 3, 1,'Не задано'),
('5712109',	'Полиэтилен, вышедшие из употребления изделия промышленно-технического назначения',	2, 3, 1, 'Не задано'),
('5712600',	'Фторопласт', 2, 3, 9, 'Не задано'),
('5712700',	'Пластмассовые упаковки и емкости с остатками вредного содержимого', 2, 3, 1, 'Не задано'),
('5712710',	'Пластмассовые отходы в виде тары из-под моющих, чистящих и других аналогичных средств', 2, 3, 11, 'Не задано'),
('5712711',	'Пластмассовые отходы в виде тары из-под ЛКМ', 2, 3, 7, 'Не задано'),
('5712802',	'Полипропилен, бракованные изделия, обрезки изделий', 2, 3, 1, 'Не задано'),
('5750119',	'Уплотнительные прокладки, манжеты, втулки и т.п. отработанные', 2,	3, 1, 'Не задано'),
('5750201',	'Изношенные шины с металлокордом', 2, 3, 1, 'Не задано'),
('5750202',	'Изношенные шины с текстильным кордом', 2, 3, 1, 'Не задано'),
('5750301',	'Отходы паронита', 2, 3, 10, 'до 25 кг/1 ремонт, до 8 кг/т продукции'),
('5750905',	'Тормозные композиционные колодки отработанные', 2, 3, 1, 'До индикатора износа тормозной колодки'),
('5820503',	'Ветошь, загрязненная лакокрасочными материалами', 2, 3, 8, '0,3 кг/т продукции'),
('5820601',	'Обтирочный материал, загрязненный маслами', 2, 3, 4, '2,18 кг/10  тыс. км пробега'),
('1471501',	'Обувь кожаная рабочая, потерявшая потребительские свойства', 3, 4, 1, '2кг на сотрудника в год'),
('1710200',	'Опилки натуральной чистой древесины', 3, 4, 12, 'Не задано'),
('1710203',	'Опилки и стружка при изготовлении оцилиндрованных, столярных и фрезерованных деталей',	3, 4, 12, 'Не задано'),
('1710700',	'Кусковые отходы натуральной чистой древесины',	3,	4, 12,'Не задано'),
('1710702',	'Кусковые отходы от производства столярных и фрезерованных деталей', 3, 4, 12, 'Не задано'),
('1720200',	'Древесные отходы строительства', 3, 4, 14, 'Не задано'),
('1722901',	'Подметь от уборки цехов и территории предприятий по обработке и переработке древесины', 3, 4, 13, 'Не задано'),
('1870500',	'Отходы рубероида',	3, 4, 1, 'Не задано'),
('1870601',	'Отходы бумаги и картона от канцелярской деятельности и делопроизводства', 3, 4, 15, 'Не задано'),
('1870605',	'Отходы упаковочного картона незагрязненные', 3, 4, 8, 'Не задано'),
('3140812',	'Стеклобой неармированного бесцветного стекла',	3, 4, 13, 'Не задано'),
('3140825',	'Отходы стекла «Триплекс»',	3, 4, 1, 'Не задано'),
('3141401',	'Лом кирпича шамотного', 3, 4, 1, 'Не задано'),
('3142405',	'Песок, загрязненный маслами (содержание масел – менее 15%)', 3, 4, 3, 'Не задано'),
('3143100',	'Отходы плит минераловатных', 3, 4, 1, 'Не задано'),
('3143701',	'Отходы асбеста в кусковой форме', 3, 4, 1, 'Не задано'),
('3144407',	'Абразивная пыль и порошок от шлифования черных металлов (с содер. металлов 50%)', 3, 4, 15, '2,9 кг/1000 обработанных деталей'),
('3145300',	'Сульфоуголь отработанный',	3, 4, 1, '1т на 1 замену фильтрующего материала'),
('3510602',	'Металлическая тара, загрязненная ЛКМ',	3, 4, 7, 'Не задано'),
('3534500',	'Батареи (элементы питания) различных моделей отработанные', 3, 4, 1, 'Не задано'),
('3991300',	'Смешанные отходы строительства', 3, 4, 1, 'Не задано'),
('5471700',	'Донные отложения мазутных резервуаров', 3,	4, 1, 'Не задано'),
('5740400',	'Отходы стекловаты', 3, 4, 1, 'Не задано'),
('5820903',	'Изношенная спецодежда хлопчатобумажная и другая', 3, 4, 1, '12 кг на одного работника'),
('8440100',	'Осадки взвешенных веществ от очистки дождевых стоков',	3, 4, 1, 'Не задано'),
('9120800',	'Отходы (смет) от уборки территорий промышленных предприятий и организаций', 3, 4, 16, 'Не задано'),
('1730200',	'Сучья, ветки, вершины', 4,	5, 17, 'Не задано'),
('1730300',	'Отходы корчевания пней', 4, 5, 19, 'Не задано'),
('3140801',	'Стеклобой бесцветный тарный', 4, 5, 10, 'Не задано'),
('3140804',	'Стеклобой полубелый листовой',	4, 5, 10, 'Не задано'),
('3141004',	'Асфальтобетон от разборки асфальтовых покрытий', 4, 5, 1, 'Не задано'),
('3141101',	'Земляные выемки, грунт, образовавшиеся при проведении землеройных работ, не загрязненные опасными веществами', 4, 5, 1, 'Не задано'),
('3142708',	'Бой железобетонных изделий', 4, 5, 1, 'Не задано'),
('3142707',	'Бой бетонных изделий',	4, 5, 1, 'Не задано'),
('3144406',	'Абразивные круги отработанные, лом отработанных абразивных кругов', 4, 5, 16, 'Не задано'),
('3144411',	'Отработанная шлифовальная шкурка', 4, 5, 19, '0,1 кг/м2 обрабатываемой поверхности'),
('3511002',	'Стружка стальная незагрязненная', 4, 5, 15, 'Не задано'),
('3511008',	'Лом стальной несортированный',	4, 5, 20, 'Не задано'),
('3511102',	'Лом чугунный несортированный',	4, 5, 20, 'Не задано'),
('3511500',	'Металлические конструкции и детали из железа и стали поврежденные', 4, 5, 21, 'Не задано'),
('3530405',	'Лом алюминия несортированный', 4, 5, 20, 'Не задано'),
('3531102',	'Стружка бронзы незагрязненная', 4, 5, 16, 'Не задано'),
('3531103',	'Лом бронзы несортированный', 4, 5, 20, 'Не задано'),
('3531202',	'Стружка латуни незагрязненная', 4, 5, 16,'Не задано'),
('3531203',	'Лом латуни несортированный', 4, 5, 20, 'Не задано'),
('5740100',	'Отходы стеклотканей', 4, 5, 1, 'Не задано'),
('9120400',	'Отходы производства, подобные отходам жизнедеятельности населения', 4, 5, 10, '54 кг на 1 сотрудника'),
('9120500',	'Уличный и дворовой смет', 4, 5, 21, 'Не задано'),
('9121100',	'Растительные отходы от уборки территорий садов, парков, скверов, кладбищ и иных озелененных территорий', 4, 5, 21, 'Не задано');






