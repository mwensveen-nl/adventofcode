package nl.mwensveen.adventofcode.year_2017.day_7;

public class RecursiveCircusSolution {
    private static String DATA = "vpryah (310) -> iedlpkf epeain\n" +
            "aqfemi (38)\n" +
            "bwtsue (18) -> crdoq lhxdfj\n" +
            "eeyaxfn (72) -> idsab jnhyc vswgxoh hivnzrk afcsq vpryah dqiby\n" +
            "vddsv (64)\n" +
            "xnoux (41)\n" +
            "apajk (61)\n" +
            "fdgjgwt (13174) -> piofa uxrros ngiys\n" +
            "tgjmrpl (43)\n" +
            "jjxhgkx (1478) -> jncwn tydjgm\n" +
            "nbrqwvs (201) -> zzkzfln htdimcs\n" +
            "qcnoadr (70)\n" +
            "wwcngr (77)\n" +
            "deweh (1549) -> qaqof kvyiqr zfmqlj\n" +
            "ygeoklq (12)\n" +
            "bpszadt (35)\n" +
            "bdlzzvy (98)\n" +
            "fbaiatg (13)\n" +
            "pidgnp (95856) -> ehlwoxs hbldvzk ezwzp tylelk jkxutle kkflx oucqw\n" +
            "vijgqvl (40)\n" +
            "ofjjqdj (46)\n" +
            "vgsqrp (46)\n" +
            "idqgxkl (81)\n" +
            "nafzy (65)\n" +
            "nxspzd (82)\n" +
            "cnrwew (222) -> vnyaqgw zooxx\n" +
            "qhdqak (2571) -> vmgxg knmmys zkwplas bsqpcne xgqdjhe\n" +
            "rxbrsd (28)\n" +
            "hubvoh (152)\n" +
            "mpwlly (12)\n" +
            "rotzn (10)\n" +
            "drswab (57)\n" +
            "udkvb (250) -> fkvhdj flhhbd\n" +
            "coedb (62)\n" +
            "fpwoels (35)\n" +
            "huzzk (131) -> fqozst naacbhr\n" +
            "etxfihy (98) -> tgjmrpl hdiprgd hospabk fvmws\n" +
            "mbtin (67)\n" +
            "yaawixo (67)\n" +
            "kxcid (77)\n" +
            "sibko (27)\n" +
            "khshj (177)\n" +
            "otnrfom (37)\n" +
            "hzqpddb (16)\n" +
            "ngiys (963) -> ybqzq vcrgmn ysmqsps bwrenq opomx\n" +
            "yybtd (16)\n" +
            "myhgys (11) -> daesbhs qrmipn\n" +
            "amhmm (64) -> pxkhwuu gnbmz\n" +
            "soiza (34)\n" +
            "dqiby (202) -> fdklcbu qcnoadr\n" +
            "jleqdi (69)\n" +
            "fdyuo (91)\n" +
            "gxmdnq (42)\n" +
            "wdnlqh (43)\n" +
            "lmmffej (337) -> twjvtbu suvwi\n" +
            "qrrdb (94) -> zqvhd vcgcmuh\n" +
            "gkzpb (207)\n" +
            "rfkdn (163) -> zpjju bxwtlj igzrzi\n" +
            "iyegmn (58)\n" +
            "johqe (47)\n" +
            "nmfhgq (141) -> dzbnx cveuc sfrwf\n" +
            "jknrln (13)\n" +
            "hivnzrk (206) -> coxuqy ewuohku\n" +
            "xulpd (54) -> itzmwqp egtem\n" +
            "quqixmj (203) -> jykfxee vsqcws\n" +
            "wjkfdvb (10)\n" +
            "fusiiz (47)\n" +
            "awvqy (71)\n" +
            "auztp (27)\n" +
            "ghuyt (65)\n" +
            "xzfrad (23)\n" +
            "nvkhow (96)\n" +
            "htdimcs (93)\n" +
            "kwolrk (90)\n" +
            "dhsyxu (35)\n" +
            "chjdhl (40)\n" +
            "gndjq (70)\n" +
            "izxeuz (97)\n" +
            "dgqquh (92)\n" +
            "yenbb (51)\n" +
            "wogrc (27)\n" +
            "cijhcl (16)\n" +
            "ebaevkk (97)\n" +
            "mxikfk (23)\n" +
            "elxfl (320) -> ohneffn jyvhtle sgymtmx mitvkt kaxvdwl\n" +
            "aivprd (58)\n" +
            "ujnas (94)\n" +
            "ubdfq (12)\n" +
            "ozuqsau (8)\n" +
            "hlszj (23)\n" +
            "tpdch (17)\n" +
            "atgamme (26)\n" +
            "nwlacty (167) -> vhuwgi zaiopar\n" +
            "kyizmdu (53)\n" +
            "xgufltj (96)\n" +
            "rqbjjuo (49)\n" +
            "pkipyhb (98)\n" +
            "mojsngw (92)\n" +
            "bncmd (95)\n" +
            "hkssn (463) -> gjpglfg bqlmhj cvseh\n" +
            "mgoew (180) -> gqmbul geqrb oidjn\n" +
            "fdvfx (58)\n" +
            "mkohhbb (82)\n" +
            "btami (41)\n" +
            "ohbhyq (20)\n" +
            "jnyvdz (98)\n" +
            "sbzee (24)\n" +
            "dyeds (47)\n" +
            "xmendwz (76)\n" +
            "dwybhqe (326) -> ftyilib lhmhrpi\n" +
            "dydlyj (88)\n" +
            "cgtddkw (164) -> jcikl jaxjy\n" +
            "jircuj (729) -> qyqthsz ctqaxh scbjq\n" +
            "xernf (34)\n" +
            "ljpeina (81)\n" +
            "dvvlx (16)\n" +
            "itzmwqp (76)\n" +
            "opbrn (78)\n" +
            "ekpvnh (61)\n" +
            "btbuwwi (105) -> btami ffrrwb niuvu atzuayu\n" +
            "ceqayn (77)\n" +
            "gtgdmny (11)\n" +
            "unqmapv (58) -> ofjjqdj vgsqrp ayogkum ymerus\n" +
            "phrrm (5)\n" +
            "botmw (78)\n" +
            "fbhxulf (40) -> flbumzk csxdpl\n" +
            "tdbwpcj (98)\n" +
            "qdfzlv (73) -> blkcnq idqgxkl\n" +
            "cfiurqp (12)\n" +
            "pejkmud (33)\n" +
            "doqxpij (154) -> xaidhn mcmijwy\n" +
            "mmjpziu (38)\n" +
            "ryjrq (69)\n" +
            "dzienj (115) -> gybbvb mbtin\n" +
            "iisuf (42)\n" +
            "mtfqemm (8)\n" +
            "gwpzvb (48) -> qjlrpjn prtah\n" +
            "pkjykh (81)\n" +
            "hgqesr (672) -> satuz zozajw hzauzw\n" +
            "ayogkum (46)\n" +
            "cdqkuuw (216) -> lhjpci mlkddpw\n" +
            "dvips (13)\n" +
            "klvhv (34)\n" +
            "kvypj (91)\n" +
            "rcytc (700) -> doqxpij dwybhqe yeuaeqp bpvit ljhqql\n" +
            "wadeqe (98)\n" +
            "dqwocyn (1215) -> aepss jtxphqg gveca\n" +
            "unbjm (40)\n" +
            "qhwtf (97)\n" +
            "afxazvx (49)\n" +
            "pyraep (46)\n" +
            "lwpwtbj (71)\n" +
            "kasozsw (143) -> sayhdkv ghhhiwl kreehw\n" +
            "xfjpbus (96)\n" +
            "llalv (35)\n" +
            "xpzadg (15) -> ydjrtcd ebaevkk\n" +
            "igzrzi (182) -> chjdhl buyou\n" +
            "skzxsyk (31)\n" +
            "hontwg (58) -> pgnbhl qoksme dzlgor gmfsl sdvag nbrqwvs\n" +
            "smmdlo (416) -> cxgdzl facddx doehwd\n" +
            "drtfi (19)\n" +
            "uglla (19)\n" +
            "mjbdmlf (67)\n" +
            "ykhycl (496) -> xmkkpat iroikgp khshj kxqhlbm vfrna\n" +
            "twvkgl (74)\n" +
            "iuagzo (69)\n" +
            "qxvpdh (28) -> qptzj hkcghm\n" +
            "poviv (76)\n" +
            "knhati (51)\n" +
            "uashrrc (50)\n" +
            "ouiwlb (98)\n" +
            "tzxvnri (12)\n" +
            "bnqutso (11)\n" +
            "fqozst (39)\n" +
            "xypex (18)\n" +
            "gerpefi (69)\n" +
            "wbqjf (24)\n" +
            "xaidhn (91)\n" +
            "lwpmgk (61)\n" +
            "wuluf (72)\n" +
            "ffrrwb (41)\n" +
            "ooobx (45)\n" +
            "fdhvp (137) -> ybjld uksim wbqjf sbzee\n" +
            "pxkhwuu (89)\n" +
            "rrxrsx (77)\n" +
            "crxbcqe (1033) -> rmocf xjiql mocrsqu\n" +
            "msywua (32)\n" +
            "zqatt (72) -> pzggi abdjb wvisr ibushn fdkvm dobqmg gbqig\n" +
            "jfclt (107) -> pjssvle tmsnmf iisuf njhppm\n" +
            "upndyov (83) -> pkcpn qvknu\n" +
            "gbbnux (279) -> yotrh bnsqqv\n" +
            "scbjq (89) -> ogorkv rvglq upnls\n" +
            "ydgusm (66)\n" +
            "sayhdkv (87)\n" +
            "nqzlzs (10)\n" +
            "coazy (129) -> wkmey skzxsyk\n" +
            "vhcza (20)\n" +
            "pgtmio (19)\n" +
            "tprgqt (81)\n" +
            "euoqdcd (62)\n" +
            "zddlo (62)\n" +
            "dlapc (26)\n" +
            "qorsgjk (62)\n" +
            "hsyoiy (23)\n" +
            "pyplv (26)\n" +
            "gqmbul (8)\n" +
            "jwgvg (62)\n" +
            "lyrxhp (90)\n" +
            "uekiz (23) -> wwcngr xqyrozn ikclk uents\n" +
            "ibyvotn (65)\n" +
            "ewtqg (51)\n" +
            "qwlze (52) -> malwro gwyrxmf blstaec ehoqrji bqppw btbuwwi\n" +
            "gjpglfg (29) -> vumpiw yfzbdl nlgoig fqppio uykfql gvujhex\n" +
            "ftohrkw (16)\n" +
            "hmtnj (28) -> qorsgjk vneld\n" +
            "qggjzz (106) -> yqxvhbl wsyqwf\n" +
            "pgilb (19)\n" +
            "hueuhx (54)\n" +
            "thats (64)\n" +
            "arveor (80)\n" +
            "yuymxvd (80) -> llbxkj zmpyqv\n" +
            "cisaxsf (161) -> rptfwu mqjpes\n" +
            "pkuqykh (68) -> bpyce fusiiz mdrto\n" +
            "otqdauw (32)\n" +
            "ylnua (76)\n" +
            "uyjtxt (87) -> gahwap fqxrjg mnxmtp\n" +
            "zfzpgfw (25) -> rwouyb gjvfc zbtswr\n" +
            "vzrfuvn (83)\n" +
            "bdzkzv (318) -> baimp wfgyg\n" +
            "ceywcm (68)\n" +
            "ypeap (60)\n" +
            "mqjqez (70)\n" +
            "iueqa (53)\n" +
            "hqhkw (70)\n" +
            "bpyce (47)\n" +
            "wseii (36)\n" +
            "vxxhu (32)\n" +
            "nqomdre (40)\n" +
            "pxnvwaj (11) -> rcytc hontwg vjhwn deweh\n" +
            "qvknu (90)\n" +
            "qcsfpn (85)\n" +
            "eprljo (98) -> hdjlp qqfgo xbhww\n" +
            "cwdfqo (6) -> ctqym nxxfgn uoenrx owdcg\n" +
            "fgzwvuy (67)\n" +
            "ajdtudl (263)\n" +
            "dngqchs (1012) -> mxpxbm quqixmj qneezf\n" +
            "zdiygz (207) -> tujrz vpmuei\n" +
            "jkxutle (5247) -> scjrx srcfgoo rfkdn\n" +
            "jeywnj (13043) -> kkjro jxysad crxbcqe pgdgh qozxrgg\n" +
            "holcno (13)\n" +
            "qtjpthc (45) -> hfpspc iniuzfq\n" +
            "malwro (93) -> saxar dydlyj\n" +
            "bujphvu (154) -> dpcuy rimobjs mevce\n" +
            "hgogzfl (17)\n" +
            "xgqdjhe (327) -> gbbnux zuanzd nbykdlk\n" +
            "rtzodmx (76)\n" +
            "mdrto (47)\n" +
            "xuwmc (256) -> yekxli xnfybs\n" +
            "ptmqsnr (83)\n" +
            "mplgqv (77)\n" +
            "uhoryyb (4957) -> slohro kkjnouk lmfchi\n" +
            "yrbwhz (19)\n" +
            "elcnwtn (110) -> mmqtzmj rnfoji xayhv\n" +
            "wtkxd (73)\n" +
            "ftyilib (5)\n" +
            "bztcy (224) -> mysjwy wbqkf\n" +
            "unnvung (64)\n" +
            "gufqi (12)\n" +
            "zntrkc (71)\n" +
            "zxdhxrb (69)\n" +
            "tzvtu (78)\n" +
            "ohneffn (65) -> ffcefem qjxyfa bojjcl bhqkvi\n" +
            "rtcicn (211) -> hqcwl pgilb dniub\n" +
            "hmwfqwz (225) -> zqczqd xdrjmkv\n" +
            "obilnz (93)\n" +
            "satuz (271)\n" +
            "fdkvm (189) -> hueuhx ujyxvl\n" +
            "mxtcei (11914) -> eeyaxfn dhrbaor mzgayzs tfphsaq\n" +
            "cqupm (71) -> vsvne wwrkqb jtgcmc yyria hkntpfd cbefqk\n" +
            "gymuodz (63) -> rimua whfeq\n" +
            "zfmqlj (121) -> kdbfv abccyo\n" +
            "muecxv (98)\n" +
            "cldldxp (14) -> uuztubk hrqsnls eeergq vyqlzi\n" +
            "acpwe (135) -> yrbpdq iwtqde\n" +
            "hcrxqbw (80)\n" +
            "xmkkpat (43) -> ivwybv mjbdmlf\n" +
            "okqwb (85)\n" +
            "pwmazwj (59)\n" +
            "qwtheza (22)\n" +
            "euxrv (110) -> sfuegcs kqfesp azjunml\n" +
            "qvowcc (30)\n" +
            "zelwp (61) -> nxspzd lrhkoc ybfqzep sqwovza\n" +
            "pqqfpa (355) -> dezgi dtakrnu\n" +
            "uykfql (405) -> efijtd phdetz\n" +
            "jyvhtle (25) -> jasol esivz wprhap fqyog\n" +
            "czyok (75) -> pkipyhb sbsfo izkej\n" +
            "vpmuei (62)\n" +
            "ydjrtcd (97)\n" +
            "bgjwy (82)\n" +
            "xupkjdt (31) -> mzjhsq cimubay\n" +
            "coxuqy (68)\n" +
            "wupsg (81)\n" +
            "prtah (59)\n" +
            "pewvv (39) -> rtcicn vysjpf lxxbgm bztcy fgbsxh\n" +
            "kemme (38)\n" +
            "rpanfr (42)\n" +
            "mmqtzmj (76)\n" +
            "auocefh (10)\n" +
            "mweox (60) -> ddrsd nxwtdg jlvakq gmaxala rtwur qqkwjoy lmmffej\n" +
            "kazlt (312) -> cgetpc jknrln\n" +
            "rqqxoou (82) -> lbeqp jfsnic\n" +
            "jrygk (124) -> zkkvh xjvwjq\n" +
            "rvglq (18)\n" +
            "ajyzem (70)\n" +
            "qhgvoj (129) -> uwpuqd pyplv\n" +
            "scgpm (19)\n" +
            "apbjfv (43)\n" +
            "waxvx (96)\n" +
            "dpqrxbr (55) -> nafzy bgscxgk\n" +
            "jtzrvt (55)\n" +
            "qnzdaj (262) -> ablgyqv xhang\n" +
            "jfvoui (45)\n" +
            "vfmiaz (38)\n" +
            "xnqznos (5)\n" +
            "qhfoy (63)\n" +
            "fsqws (95) -> yyrwb vnuwoq vlllp reuaanp\n" +
            "aunrdo (61)\n" +
            "pbcpt (7)\n" +
            "xwunxz (1100) -> klhzgvj walzh snquxtz\n" +
            "lshkygc (19)\n" +
            "bkqndr (44)\n" +
            "dhrbaor (1511) -> fpkuumw fytlv knendm xxsobt wlqfnkr\n" +
            "opomx (191) -> pycim khnemp\n" +
            "zlvgiq (76)\n" +
            "oioqg (63)\n" +
            "dkeosz (13)\n" +
            "irgymg (99)\n" +
            "iyqcty (19)\n" +
            "ozugcs (60)\n" +
            "ewoebye (55)\n" +
            "dxggcx (34) -> nuwpvd ylnua vljooo ykzjkp\n" +
            "qyvxs (83) -> qtcsae gjdrco zffoytm\n" +
            "ogorkv (18)\n" +
            "zuanzd (73) -> tutmv ubkhce ebzton\n" +
            "qozxrgg (1351) -> yuymxvd zjuupn uyjtxt\n" +
            "lbeqp (62)\n" +
            "bqlmhj (2246) -> cvahi jgbvdp wehfli\n" +
            "ptyuh (70)\n" +
            "jlhsd (41) -> ygnlbv wochkc nzazpe\n" +
            "ayfafvc (33)\n" +
            "ldmgzql (17) -> qsods ewoebye yesozb bfqotji\n" +
            "rdytzgp (127374) -> uhoryyb vfwwc hkssn\n" +
            "nxxfgn (59)\n" +
            "iniuzfq (81)\n" +
            "vysjpf (228) -> ohbhyq bhzeep\n" +
            "scjrx (448) -> ejoee uyvuqp yaera\n" +
            "tzobgt (88)\n" +
            "ljhqql (44) -> tbzqsrb wtkxd amhug axgpt\n" +
            "vvpacb (126) -> ijmaxm cjoeyrm\n" +
            "zqvhd (88)\n" +
            "zagaz (88)\n" +
            "emhblpr (85)\n" +
            "lrosl (82)\n" +
            "orcrc (74)\n" +
            "vyfhcqp (109) -> jwgvg pyfeav\n" +
            "njhppm (42)\n" +
            "eowjgp (188) -> ueqkrm nhgchm\n" +
            "wlodh (39)\n" +
            "vsqcws (25)\n" +
            "jxcxv (60)\n" +
            "hybvw (92)\n" +
            "qdgsn (47)\n" +
            "jasol (41)\n" +
            "zgrcahy (64)\n" +
            "mhassg (80)\n" +
            "eeergq (53) -> oeehfxg emhblpr\n" +
            "ojozup (29)\n" +
            "gmeqmy (66) -> mbslas vimplcz\n" +
            "zzekx (81)\n" +
            "xjvwjq (14)\n" +
            "heezga (300) -> jtfdy scgpm\n" +
            "pjhoue (56)\n" +
            "djejdy (98) -> fdvfx ykoazai\n" +
            "fkzxmb (55)\n" +
            "ezwzp (7179) -> jlhsd oedan emuek\n" +
            "tlwqwlk (23)\n" +
            "fqyog (41)\n" +
            "elvzp (33)\n" +
            "ydusqh (80) -> qucxsqh lrfttlb vzrfuvn ptmqsnr\n" +
            "dweli (58)\n" +
            "qbnldp (85) -> cguzndh oldoxo\n" +
            "xbhww (55)\n" +
            "smjtypd (35)\n" +
            "vcgcmuh (88)\n" +
            "iedlpkf (16)\n" +
            "zttytvi (93) -> qkjed jnxbxzk\n" +
            "bszaj (104) -> txhbij kwolrk\n" +
            "qwagq (67)\n" +
            "gxzxapn (12)\n" +
            "fqppio (139) -> fllao orcrc uhmmouc twvkgl\n" +
            "opnpx (94)\n" +
            "esivz (41)\n" +
            "iqbtc (94)\n" +
            "wznad (369)\n" +
            "nujmyt (309) -> vbzyp qwagq\n" +
            "vuzkop (57)\n" +
            "dxzahps (8)\n" +
            "idsab (142) -> befsr mhlgi uashrrc fkmyndg\n" +
            "vtjrflg (73)\n" +
            "wfgyg (69)\n" +
            "ghhhiwl (87)\n" +
            "phpjy (44)\n" +
            "ekffumh (295) -> wznad metsfo afycii czyok\n" +
            "jhltpk (61)\n" +
            "kaxvdwl (125) -> hzqpddb aqeqvr esegn hdyrxg\n" +
            "uxgux (53)\n" +
            "zhnug (77)\n" +
            "cjoeyrm (72)\n" +
            "sdvag (387)\n" +
            "efbvz (54)\n" +
            "rksqqfr (90)\n" +
            "xplsuaq (98)\n" +
            "joryloo (24)\n" +
            "mxpxa (128) -> vtjrflg guccv\n" +
            "tjcujd (193) -> cmfit tcvpst\n" +
            "wkmey (31)\n" +
            "hgkjgm (4609) -> xcjxzq ekffumh juscckl dngqchs\n" +
            "vneld (62)\n" +
            "lmfchi (67) -> qnzdaj efqrg murzaw\n" +
            "umajdu (17)\n" +
            "ierjhuk (15)\n" +
            "bvviqc (60)\n" +
            "qcizo (70)\n" +
            "cwaymbr (98)\n" +
            "iemeek (37)\n" +
            "lhxdfj (92)\n" +
            "nlgoig (240) -> xyfsr ghuyt ibyvotn\n" +
            "xxviu (12)\n" +
            "doehwd (169) -> ahcba pbqdzda xijkpj\n" +
            "nzazpe (88)\n" +
            "wehfli (105) -> asuodq fbaiatg\n" +
            "athdvrh (3021) -> ajika gxmdnq\n" +
            "hwluwdo (5)\n" +
            "yvttt (201) -> fdgccyg joryloo\n" +
            "dyxzd (216) -> gubya pnxmfdc\n" +
            "ehoqrji (79) -> kqvsah yanwn\n" +
            "iwdzu (98)\n" +
            "owdcg (59)\n" +
            "vgaxwnn (78)\n" +
            "wlqfnkr (47) -> wseii axhfcb iomjmn rczoepp\n" +
            "jxysad (99) -> jtydj udkvb plpctjz ydusqh\n" +
            "jaedvjj (76)\n" +
            "iemgv (23)\n" +
            "skjez (147) -> aivprd cbdyc\n" +
            "bwrenq (295) -> lyaqynn hlcnf\n" +
            "hoarkjh (12)\n" +
            "tyvhz (222) -> wjkfdvb powfmo\n" +
            "yiyjz (71) -> ljpeina zzekx\n" +
            "fiwnjv (45)\n" +
            "dzwnlq (54)\n" +
            "algav (26)\n" +
            "nhgchm (47)\n" +
            "ejoee (115) -> algav atgamme\n" +
            "jncwn (94)\n" +
            "gypuu (21)\n" +
            "xeiur (185)\n" +
            "zqczqd (82)\n" +
            "zordz (166) -> zhubam hoarkjh\n" +
            "xtocem (23) -> ajyzem hqhkw jcshcvr zxbnkvs\n" +
            "hhndlt (17641) -> sfxvp ypzqp pewvv\n" +
            "rrtpjw (7238) -> ptfyi hgqesr jmdlczf\n" +
            "aduuei (65)\n" +
            "dzrywb (84)\n" +
            "fpnjjy (91) -> dgqquh ftatt\n" +
            "wprhap (41)\n" +
            "cvahi (39) -> auorp jypccpq\n" +
            "gxhjjv (62)\n" +
            "zbrhqwq (171) -> kckevg pbcpt\n" +
            "rimua (86)\n" +
            "fxqaw (63) -> avfsez tprgqt\n" +
            "lyorl (80)\n" +
            "csmjw (142) -> hwluwdo phrrm\n" +
            "crqesym (75)\n" +
            "gkskqqb (13)\n" +
            "cnuygks (10)\n" +
            "owxbfr (80)\n" +
            "gubya (56)\n" +
            "nnjrm (69) -> nesoknh mkohhbb\n" +
            "gjdrco (85)\n" +
            "gtditk (58)\n" +
            "vlfxdli (66)\n" +
            "qwtvro (870) -> cfiurqp ubdfq xxviu\n" +
            "isoayc (6)\n" +
            "coicjc (185)\n" +
            "yuktpa (74)\n" +
            "txnuvci (44)\n" +
            "jbomczw (82)\n" +
            "jykfxee (25)\n" +
            "yyria (21) -> qztfbzn xfmneu\n" +
            "xgibks (66) -> qvuhbo abspab ehegh bvelsl\n" +
            "liklroi (108) -> xowek qdgsn\n" +
            "kdbfv (78)\n" +
            "flhhbd (81)\n" +
            "halwu (66)\n" +
            "enorooc (44)\n" +
            "jfnknli (2345) -> hubvoh csmjw kzpyvis hmyuwix fbhxulf\n" +
            "yeuaeqp (162) -> vojcrx jnshvhq\n" +
            "plzrspg (188) -> pdprpyn itacy\n" +
            "jcshcvr (70)\n" +
            "uckyywt (96)\n" +
            "zpyoxs (52)\n" +
            "gvujhex (419) -> jbmxm ozuqsau\n" +
            "zxbnkvs (70)\n" +
            "ydcibyi (1431) -> sakmn yuktpa ielyzgp\n" +
            "ffcefem (31)\n" +
            "mxpxbm (77) -> mvldvib phpjy mtqdya enorooc\n" +
            "yzssszb (80)\n" +
            "srltg (96)\n" +
            "txznlay (55)\n" +
            "jwmjagj (30)\n" +
            "ejzoa (468) -> pqqfpa fsqws kqhusg\n" +
            "iwtqde (57)\n" +
            "tdxsqf (391) -> ejrychc wqpfc\n" +
            "hrqsnls (133) -> ooobx jfvoui\n" +
            "ewgvg (14873) -> sohohlc fxhlrok ykhycl xabull gdvqsyp\n" +
            "flgjahm (5240) -> bwhovd zqatt hcqsg\n" +
            "odtetse (25)\n" +
            "floca (98)\n" +
            "jfsnic (62)\n" +
            "hdiprgd (43)\n" +
            "fwfbd (81) -> djxvowe mssypcn\n" +
            "whfeq (86)\n" +
            "lrfttlb (83)\n" +
            "aygltsd (44)\n" +
            "ztoitoz (59)\n" +
            "zooxx (30)\n" +
            "cumlar (39)\n" +
            "gzarnps (75) -> mojsngw hybvw ssuho phmoj\n" +
            "lpgtx (63)\n" +
            "psdhpk (110) -> ceqayn kimsadh\n" +
            "jfvmu (44)\n" +
            "hfpspc (81)\n" +
            "nghcpr (88)\n" +
            "idfuz (87) -> lwpmgk scfrwrg\n" +
            "qqnroz (666) -> uvexl ldmgzql vtphqb tjcujd\n" +
            "tutmv (94)\n" +
            "gmaxala (403) -> yybtd cijhcl\n" +
            "kimsadh (77)\n" +
            "tbzqsrb (73)\n" +
            "ijmaxm (72)\n" +
            "biokfm (155) -> nvflr sabolzl\n" +
            "lnllv (255) -> tpdch nyeur\n" +
            "ulpfyrr (93)\n" +
            "twjvtbu (49)\n" +
            "qkdiej (25)\n" +
            "deyxep (58)\n" +
            "jbolstg (1053) -> aizud hxowycm fzcerr\n" +
            "jvxecw (59)\n" +
            "rxwxqe (53)\n" +
            "geqrb (8)\n" +
            "fytlv (35) -> pshil bppdgwm\n" +
            "lbgqy (20)\n" +
            "gmtsea (8)\n" +
            "nbvlp (47)\n" +
            "vkdpaip (50) -> xfjpbus ilkhnhw\n" +
            "btsvvyg (21)\n" +
            "shjlwli (264)\n" +
            "uzxjt (8)\n" +
            "xichd (209)\n" +
            "vhuwgi (20)\n" +
            "plmaxee (62)\n" +
            "texooeb (55)\n" +
            "qneezf (143) -> bsnxzz yntilqc\n" +
            "dzlgor (43) -> jnmgovh lzqtep umuur nuajwg\n" +
            "ubkhce (94)\n" +
            "cvxkylq (99)\n" +
            "ctqaxh (61) -> tslfayy xquzvw\n" +
            "yfzbdl (75) -> kmyvyx lyrxhp tuyon rksqqfr\n" +
            "rdrrye (338)\n" +
            "jrgiha (7)\n" +
            "wpugb (69) -> xhubgcl psdhpk htgvzw shjlwli xtxppp nusvn\n" +
            "odmmo (456)\n" +
            "hgblqo (31)\n" +
            "jcikl (59)\n" +
            "khkaq (16)\n" +
            "mcmijwy (91)\n" +
            "sgymtmx (85) -> uxbyymt tnngtb\n" +
            "fqxrjg (15)\n" +
            "rhfznek (52) -> vckzclh kurnhks ftthnl fseduzt gxumijt\n" +
            "txhbij (90)\n" +
            "yaann (187) -> drtfi golkvpd\n" +
            "dfolgy (80)\n" +
            "qoukeij (82) -> szdthny bpszadt\n" +
            "rmocf (100) -> fkbivys ryjrq\n" +
            "rpxni (39)\n" +
            "xmvthbd (40)\n" +
            "soddek (333) -> wragpj qcldyng\n" +
            "gwyrxmf (93) -> ntugl bkqndr nhnwkzo txnuvci\n" +
            "bzwiavk (122) -> vszfxh unbjm hkxefzm vijgqvl\n" +
            "okrnkqa (70)\n" +
            "pasveb (20)\n" +
            "qxivh (85)\n" +
            "aakrpyc (14)\n" +
            "qfellsp (80)\n" +
            "yowbd (346) -> ooazmvu jtzrvt\n" +
            "ielyzgp (74)\n" +
            "ihslyyb (51)\n" +
            "faubz (59)\n" +
            "itacy (93)\n" +
            "fwevqj (33)\n" +
            "zzsbd (78)\n" +
            "edygy (258) -> yzfnlfl hwdkwn\n" +
            "sohswca (66)\n" +
            "jngifv (614) -> rdthc ajdtudl skjez eprljo\n" +
            "ivfffiz (96) -> iqbtc opnpx\n" +
            "hcbdbh (400) -> cibrtjo gkxdmxg\n" +
            "rulkpe (27) -> faubz ftbsur luixm jvxecw\n" +
            "fpkuumw (31) -> arveor hsykei\n" +
            "xabull (769) -> egkqlyz obdtlhg mgoew\n" +
            "cvcvyeu (100) -> rawfw ceywcm\n" +
            "wjqdusq (186) -> odtetse swastze\n" +
            "khnemp (95)\n" +
            "rudbmkz (30)\n" +
            "llbxkj (26)\n" +
            "tbfkvty (97) -> aymgd glmcscm coedb\n" +
            "kufceqa (95)\n" +
            "exaqlbc (186) -> tejonrz hlszj\n" +
            "hxxexy (82)\n" +
            "cveuc (57)\n" +
            "pnxmfdc (56)\n" +
            "jtwrh (43)\n" +
            "pfuyke (217) -> hsyoiy ovfby\n" +
            "wdgfw (49)\n" +
            "obdtlhg (66) -> pbmni gerpefi\n" +
            "abdjb (285) -> nzhfbo begrb\n" +
            "onwhg (40)\n" +
            "wfixt (70)\n" +
            "ngtpz (98)\n" +
            "gxumijt (297) -> yrbwhz yxzdn otslex\n" +
            "murzaw (64) -> cwaymbr iwdzu ouiwlb\n" +
            "jtxphqg (108) -> aakrpyc vjyhqx\n" +
            "wjkqpqr (235) -> auocefh cnuygks nkxdfu rotzn\n" +
            "vsvne (183) -> qkllvda uzxjt\n" +
            "jqhify (94)\n" +
            "ntadc (61)\n" +
            "niuvu (41)\n" +
            "bbsvfl (6)\n" +
            "powvrta (32)\n" +
            "nvflr (64)\n" +
            "kebfmsz (269) -> fhryrfj vxxhu wycfrkz wrurg\n" +
            "ueqkrm (47)\n" +
            "elyuo (55)\n" +
            "kzpyvis (24) -> akumg dfghz\n" +
            "fozgkmk (28)\n" +
            "skdbvqr (4471) -> smmdlo cqupm buyazh elxfl\n" +
            "pycim (95)\n" +
            "spgyst (88)\n" +
            "vojcrx (87)\n" +
            "xorbfm (20) -> pwmazwj ztoitoz udiykt\n" +
            "wsyiyen (504) -> cisaxsf rejss zbrhqwq xeiur fyfjc eaxqpmn\n" +
            "ivwybv (67)\n" +
            "zsjvdo (128) -> omnyr hrhfd\n" +
            "uvfou (368) -> ygeoklq tzxvnri gufqi\n" +
            "objgx (80)\n" +
            "zpcqx (226) -> izxeuz qhwtf\n" +
            "emuek (149) -> tzvtu zzsbd\n" +
            "dytadg (35)\n" +
            "crdoq (92)\n" +
            "lljifba (68) -> jeywnj fdgjgwt ewgvg mxtcei wetrsmz sgvaf hhndlt\n" +
            "hcizj (91)\n" +
            "zzkzfln (93)\n" +
            "hmjzw (117) -> aujgtj lshkygc\n" +
            "blkcnq (81)\n" +
            "udiykt (59)\n" +
            "nhnwkzo (44)\n" +
            "tiunb (46)\n" +
            "ccbgy (64)\n" +
            "khjexez (59)\n" +
            "tydjgm (94)\n" +
            "mssypcn (56)\n" +
            "swpjozm (66)\n" +
            "yryyz (249)\n" +
            "vdham (232)\n" +
            "scfrwrg (61)\n" +
            "xyfsr (65)\n" +
            "golkvpd (19)\n" +
            "qovcwth (59)\n" +
            "dzngp (183) -> onwhg xmvthbd\n" +
            "vqbfan (51)\n" +
            "pkdeoh (16)\n" +
            "foozzq (114) -> klsxgx kcorlw\n" +
            "ehegh (54)\n" +
            "kqhusg (155) -> dfolgy yzssszb qfellsp\n" +
            "jxzfb (88)\n" +
            "airlri (97) -> pidgnp lljifba gmewl tbedct ryvidhy rdytzgp\n" +
            "kreehw (87)\n" +
            "zkkjh (93)\n" +
            "vqlyyx (43)\n" +
            "mkbjgur (34)\n" +
            "faqsp (40)\n" +
            "fiqnz (32)\n" +
            "esyzn (66)\n" +
            "swastze (25)\n" +
            "wbiys (58)\n" +
            "xiyhl (49) -> ktvry ezoar\n" +
            "aonpvtr (82)\n" +
            "pgibhk (75)\n" +
            "axgpt (73)\n" +
            "kxqhlbm (31) -> sulyr qeksx\n" +
            "apgqnys (82)\n" +
            "osipmuv (366) -> qkaaq ffrgif qxvpdh\n" +
            "lzqtep (86)\n" +
            "jrjkj (69)\n" +
            "omnyr (37)\n" +
            "jmdlczf (22) -> idfuz xichd pkuqykh xpzadg kioxu huzzk vgrbrzc\n" +
            "vvivo (60)\n" +
            "uents (77)\n" +
            "utprdt (33) -> ihslyyb knhati\n" +
            "lcqed (45)\n" +
            "vnyaqgw (30)\n" +
            "szdthny (35)\n" +
            "rwqopie (35)\n" +
            "vgrbrzc (11) -> swpjozm ibdon sohswca\n" +
            "spjim (73)\n" +
            "bipyp (78)\n" +
            "mvxqfe (85)\n" +
            "vlszzu (333) -> nafvoj foozzq jgwajk ppedet hqpkdyb\n" +
            "jdrkeh (5)\n" +
            "ftbsur (59)\n" +
            "uldlh (30)\n" +
            "dzbnx (57)\n" +
            "vswgxoh (63) -> obilnz zkkjh ulpfyrr\n" +
            "xbowtoi (53) -> tdbwpcj muecxv\n" +
            "mysjwy (22)\n" +
            "tetyj (135) -> xckaw tadprtr\n" +
            "pbqdzda (38)\n" +
            "gahwap (15)\n" +
            "vjyhqx (14)\n" +
            "aywrlw (132) -> xxvfb bmxoqy\n" +
            "zgzxr (235) -> ewvlay slclu\n" +
            "jgwajk (104) -> fdyuo keoqd\n" +
            "powfmo (10)\n" +
            "auorp (46)\n" +
            "jtydj (372) -> rpsmo lbgqy\n" +
            "iomjmn (36)\n" +
            "slclu (34)\n" +
            "isvfa (95)\n" +
            "mhcyj (61) -> gxhjjv ipppjn\n" +
            "rpsmo (20)\n" +
            "flbumzk (56)\n" +
            "xtxppp (72) -> miidkpe srltg\n" +
            "vpsls (6)\n" +
            "hlansqa (53)\n" +
            "znbvji (44)\n" +
            "kieild (43)\n" +
            "klsxgx (86)\n" +
            "asuodq (13)\n" +
            "tuuzrr (98)\n" +
            "xckaw (50)\n" +
            "efqrg (202) -> vgaxwnn opbrn\n" +
            "ibagnjs (59)\n" +
            "vyevfn (120) -> jtwrh kieild gmevoe\n" +
            "kvyiqr (95) -> kvypj hcizj\n" +
            "qghotl (82)\n" +
            "pzywvr (92) -> txswi jljgd hxxexy apgqnys\n" +
            "akmsaq (97)\n" +
            "mhseysh (49)\n" +
            "uarsqn (53)\n" +
            "ryvidhy (123921) -> pxnvwaj skdbvqr qhdqak\n" +
            "cqdggj (216) -> efkyht gtgdmny ohbzmqz\n" +
            "ykoazai (58)\n" +
            "sydiov (1417) -> xvhpqmh exaex utprdt\n" +
            "algetkl (73)\n" +
            "hbldvzk (2628) -> sydiov ropjtoe rhfznek\n" +
            "pzggi (189) -> efbvz dzwnlq\n" +
            "rnfoji (76)\n" +
            "ytfnug (39)\n" +
            "jpxgvjl (82)\n" +
            "yotrh (38)\n" +
            "xpqnuh (31)\n" +
            "ewuohku (68)\n" +
            "vlllp (75)\n" +
            "erpdg (544) -> rdnozh plzrspg tirehn\n" +
            "ablgyqv (48)\n" +
            "yqxvhbl (42)\n" +
            "hgrjt (98)\n" +
            "joees (23)\n" +
            "eqsqenp (26)\n" +
            "mnxmtp (15)\n" +
            "wetrsmz (16444) -> wpfywy litnjrv rpmtne\n" +
            "bkicgcc (33)\n" +
            "dwvbnp (80)\n" +
            "qptzj (76)\n" +
            "ibvyfys (220) -> rpzit bepnzsh khjexez\n" +
            "bwhovd (457) -> yhgutqw amhmm cwdfqo vlaowv vkdpaip tyvhz unqmapv\n" +
            "fyfjc (21) -> qghotl jbomczw\n" +
            "zaiopar (20)\n" +
            "rimobjs (88)\n" +
            "ipfmr (121) -> mkvblbi btrdhk\n" +
            "mbslas (81)\n" +
            "zkwplas (63) -> tdxsqf gzarnps nujmyt\n" +
            "hoilkqz (84)\n" +
            "jljgd (82)\n" +
            "wfwma (85)\n" +
            "rfeqsq (77)\n" +
            "ptfyi (789) -> exaqlbc vdham vxjvov\n" +
            "jdtwus (115) -> cumlar rpxni\n" +
            "ddrsd (319) -> aibabp dweli\n" +
            "buyou (40)\n" +
            "plrma (94)\n" +
            "cmfit (22)\n" +
            "nbjrv (39)\n" +
            "aizud (118) -> eirze xnoux\n" +
            "jgbvdp (91) -> pasveb vhcza\n" +
            "vckzclh (240) -> vuzkop gpgmx\n" +
            "xdzya (8219) -> malnjq jircuj zxdfpy\n" +
            "zfaxas (30)\n" +
            "keoqd (91)\n" +
            "xnqeu (30)\n" +
            "wycfrkz (32)\n" +
            "oidjn (8)\n" +
            "ihmqbiu (1005) -> hcbdbh abicjs rpiuf zpcqx pzywvr\n" +
            "rpiuf (332) -> znbvji rjjeggt\n" +
            "ygykyu (85)\n" +
            "abicjs (375) -> ierjhuk psmvz nfkbhas\n" +
            "ehclf (40)\n" +
            "okmwjoa (92)\n" +
            "uxbyymt (52)\n" +
            "xqyrozn (77)\n" +
            "eaxqpmn (9) -> zagaz tzobgt\n" +
            "undug (38)\n" +
            "uxrros (89) -> kebfmsz sqnfn mlztke ibvyfys facjth soddek kxsefnd\n" +
            "rlyxbi (303) -> qrrdb vvpacb klcuumi etxfihy tptxpuq\n" +
            "vmgxg (652) -> coicjc dpqrxbr mhcyj pzmmc\n" +
            "xoabt (58)\n" +
            "qztfbzn (89)\n" +
            "jbmxm (8)\n" +
            "noqmsh (81)\n" +
            "pgujeq (325) -> fiqnz msywua\n" +
            "gmewl (70663) -> sxpee flgjahm hrbukg rrtpjw hgkjgm twxwam xdzya\n" +
            "pnszexz (43) -> ycxyxg ycnnc\n" +
            "aledrs (33)\n" +
            "rwouyb (94)\n" +
            "uuztubk (139) -> rxbrsd hwekwoq ffzjjj\n" +
            "uwojoup (80)\n" +
            "svlvlj (254) -> pqsfee fguhavr\n" +
            "ykzjkp (76)\n" +
            "vfrna (72) -> dhsyxu dytadg gjihp\n" +
            "vimplcz (81)\n" +
            "cwppzzd (58)\n" +
            "bstqyq (35)\n" +
            "mtqdya (44)\n" +
            "enmoyyj (10)\n" +
            "lfqtv (510) -> lnllv gelep lwujegj uowiif\n" +
            "aujgtj (19)\n" +
            "hdyrxg (16)\n" +
            "ezoar (72)\n" +
            "zkkvh (14)\n" +
            "ylmwjuo (155)\n" +
            "mdanw (181)\n" +
            "klhzgvj (77) -> qmsxr wuluf\n" +
            "rpmtne (88) -> heezga xuwmc rdrrye qyvxs sppxgv\n" +
            "zozajw (139) -> esyzn vlfxdli\n" +
            "drfzng (58) -> hmwfqwz zelwp pgujeq gzqutgv\n" +
            "hzauzw (75) -> hgrjt tuuzrr\n" +
            "aepss (136)\n" +
            "zkaqnra (1790) -> upndyov mcnsxuh rulkpe pfuyke dzngp\n" +
            "egtem (76)\n" +
            "reuaanp (75)\n" +
            "apexe (85) -> pkjykh wupsg kdrke\n" +
            "agmao (53)\n" +
            "ctdsj (58)\n" +
            "izkej (98)\n" +
            "wfpxk (30)\n" +
            "cmqni (56)\n" +
            "qoksme (241) -> algetkl xhqrf\n" +
            "otslex (19)\n" +
            "vumpiw (269) -> uwoyjsd xdwrl\n" +
            "zimidd (21) -> hcrxqbw uwojoup\n" +
            "eegwdp (82)\n" +
            "pjssvle (42)\n" +
            "zbtswr (94)\n" +
            "dzugjhb (60) -> orxgo irgymg cvxkylq svfgh\n" +
            "befsr (50)\n" +
            "lrhkoc (82)\n" +
            "cbaah (5)\n" +
            "cimubay (62)\n" +
            "vnuwoq (75)\n" +
            "vbzyp (67)\n" +
            "exaex (135)\n" +
            "nmvki (40)\n" +
            "xdwrl (83)\n" +
            "gmfsl (306) -> yktmvtf auztp vhlizib\n" +
            "wsyqwf (42)\n" +
            "phdetz (15)\n" +
            "krquje (51)\n" +
            "vyqlzi (111) -> wnqny hwhhyhh\n" +
            "qmsxr (72)\n" +
            "ojzpzsa (10)\n" +
            "qvuhbo (54)\n" +
            "esegn (16)\n" +
            "bdqnomo (80)\n" +
            "tgexl (76)\n" +
            "nuvrtnk (69)\n" +
            "zarww (162) -> vrqdv ojozup\n" +
            "qqmpq (2091) -> dxggcx kazlt elcnwtn\n" +
            "pgdgh (1072) -> uzoroj yaann pnszexz\n" +
            "walzh (127) -> nbvlp suyawzr\n" +
            "kkjro (582) -> vyfhcqp yiyjz nnjrm oojlo fdhvp\n" +
            "sxpee (31) -> sppgjfx qwlze erpdg xngnhi jngifv jjxhgkx lfqtv\n" +
            "jnshvhq (87)\n" +
            "ppavww (82)\n" +
            "vljooo (76)\n" +
            "zdaorg (42)\n" +
            "hlcnf (43)\n" +
            "mzgayzs (814) -> hpsljy rgpazuy wjqdusq cvcvyeu qfzyvjr euxrv xfkpfqd\n" +
            "dfntl (44)\n" +
            "efijtd (15)\n" +
            "sqcet (53)\n" +
            "malnjq (550) -> xqrnd jrygk qoukeij hmtnj\n" +
            "ktvry (72)\n" +
            "fkvhdj (81)\n" +
            "qtcsae (85)\n" +
            "uwpuqd (26)\n" +
            "oeehfxg (85)\n" +
            "nfchpk (47) -> amooqlb rxwxqe uarsqn\n" +
            "hykmnhl (82)\n" +
            "tadprtr (50)\n" +
            "kqfesp (42)\n" +
            "piofa (2046) -> mxpxa jbkek cqupq\n" +
            "fseduzt (174) -> cbacfi ypeap vvivo\n" +
            "moeujf (181) -> bkfbj apajk\n" +
            "vlysce (28)\n" +
            "xowek (47)\n" +
            "cqfyjm (68)\n" +
            "nzhfbo (6)\n" +
            "ovfby (23)\n" +
            "nkxdfu (10)\n" +
            "ooazmvu (55)\n" +
            "qrmipn (77)\n" +
            "wragpj (32)\n" +
            "bgasdfq (408) -> zxphdt jdrkeh\n" +
            "srcfgoo (9) -> tetyj qdfzlv gymuodz qbnldp\n" +
            "hztzf (152) -> spgyst jxzfb\n" +
            "ebzton (94)\n" +
            "imdqhns (35)\n" +
            "tejonrz (23)\n" +
            "yvpzbgp (64)\n" +
            "luviddq (61)\n" +
            "akumg (64)\n" +
            "ixwoprg (102) -> zpyoxs wwkdvm\n" +
            "uowiif (106) -> luviddq jhltpk dtsdw\n" +
            "zznnz (18)\n" +
            "dnmsps (61) -> plrma jqhify\n" +
            "wfkxhlf (82)\n" +
            "yyrwb (75)\n" +
            "kdwict (157) -> umajdu hgogzfl\n" +
            "gpgmx (57)\n" +
            "mzjhsq (62)\n" +
            "cxgdzl (27) -> glumdc unnvung ccbgy zgrcahy\n" +
            "knendm (39) -> jaedvjj poviv\n" +
            "xymtys (154) -> ayfafvc ywrze\n" +
            "xrmslfs (214)\n" +
            "ycnnc (91)\n" +
            "plpctjz (296) -> cwppzzd taaoji\n" +
            "qazqwkj (30)\n" +
            "swqgxh (76)\n" +
            "phmoj (92)\n" +
            "knmmys (620) -> pyhohkx xiyhl jdtwus fwfbd\n" +
            "vcrgmn (227) -> zhnug rfeqsq\n" +
            "cibrtjo (10)\n" +
            "kkjnouk (9) -> tbfkvty vaqhekv zbxopzp biokfm\n" +
            "bpmus (87)\n" +
            "yntilqc (55)\n" +
            "ejrychc (26)\n" +
            "nusvn (104) -> kqokslj owxbfr\n" +
            "begrb (6)\n" +
            "axhfcb (36)\n" +
            "lgmjeng (35)\n" +
            "kqfob (25)\n" +
            "qqfgo (55)\n" +
            "fsose (121) -> tmpysyn hsjbzgd\n" +
            "hospabk (43)\n" +
            "cvxcr (23)\n" +
            "nefpbc (64)\n" +
            "dpcuy (88)\n" +
            "zsratan (39)\n" +
            "gybbvb (67)\n" +
            "tbedct (142596) -> ydcibyi ejzoa lcbkylu wpugb rlyxbi jbolstg\n" +
            "wpxhphx (146) -> otnrfom iemeek\n" +
            "xjiql (84) -> mplgqv rrxrsx\n" +
            "kurnhks (54) -> zlsrhdz pgibhk zsancei crqesym\n" +
            "fknai (16)\n" +
            "abccyo (78)\n" +
            "jaxjy (59)\n" +
            "zxdfpy (59) -> ikeiwjo qwfosq mmotdue hjkrxly zttytvi swjcx kvheuf\n" +
            "cgetpc (13)\n" +
            "wwrkqb (185) -> ruhqq jrgiha\n" +
            "sfrwf (57)\n" +
            "qjxyfa (31)\n" +
            "vhlizib (27)\n" +
            "hwekwoq (28)\n" +
            "mocrsqu (109) -> vqlyyx wdnlqh apbjfv\n" +
            "mevce (88)\n" +
            "yldsmt (57)\n" +
            "wwkdvm (52)\n" +
            "reqlm (51)\n" +
            "pdprpyn (93)\n" +
            "irgumpr (71) -> xgibks eowjgp bzwiavk cgtddkw tinitt cnrwew\n" +
            "jjdfk (53)\n" +
            "lmtebyt (85)\n" +
            "ibdon (66)\n" +
            "jjvbyf (62)\n" +
            "ncffht (97)\n" +
            "hpsljy (156) -> cukfipr nqomdre\n" +
            "wqpfc (26)\n" +
            "glmcscm (62)\n" +
            "mitvkt (137) -> dlapc eqsqenp\n" +
            "kmemzft (51)\n" +
            "gqwfi (51)\n" +
            "lhmhrpi (5)\n" +
            "tirehn (80) -> bdlzzvy jnyvdz zkwzctg\n" +
            "tmsnmf (42)\n" +
            "lxxbgm (56) -> hlansqa agmao dihvt uxgux\n" +
            "yhonqw (579) -> tcaex nwlacty gkzpb qtjpthc ipfmr\n" +
            "oedan (21) -> zntrkc lwpwtbj awvqy mmomd\n" +
            "gelep (34) -> qxivh lmtebyt wfwma\n" +
            "fllao (74)\n" +
            "sabolzl (64)\n" +
            "tmpysyn (22)\n" +
            "wrurg (32)\n" +
            "sfuegcs (42)\n" +
            "bhqkvi (31)\n" +
            "qgkaso (58)\n" +
            "fhryrfj (32)\n" +
            "hjkrxly (47) -> texooeb elyuo\n" +
            "ssuho (92)\n" +
            "rejss (89) -> powvrta fojnd otqdauw\n" +
            "ffzjjj (28)\n" +
            "qkaaq (180)\n" +
            "suvwi (49)\n" +
            "rczoepp (36)\n" +
            "bhzeep (20)\n" +
            "kkflx (7330) -> coazy kdwict ojcpgj qjdqn\n" +
            "gkxdmxg (10)\n" +
            "upnls (18)\n" +
            "bepnzsh (59)\n" +
            "xxsobt (137) -> zznnz ziyta xypex\n" +
            "bgscxgk (65)\n" +
            "tptxpuq (194) -> kemme vfmiaz\n" +
            "qummd (77)\n" +
            "efkyht (11)\n" +
            "mmomd (71)\n" +
            "sulyr (73)\n" +
            "txswi (82)\n" +
            "ksbjftc (185) -> gfghu spjim\n" +
            "gjvfc (94)\n" +
            "egkqlyz (148) -> vlysce fozgkmk\n" +
            "aqeqvr (16)\n" +
            "kvheuf (63) -> johqe dyeds\n" +
            "ajika (42)\n" +
            "dihvt (53)\n" +
            "zmpyqv (26)\n" +
            "xxvfb (17)\n" +
            "fvmws (43)\n" +
            "hsjbzgd (22)\n" +
            "uyvuqp (79) -> dfntl jfvmu\n" +
            "cvseh (2033) -> liklroi zsjvdo bwtsue\n" +
            "juscckl (99) -> svlvlj bujphvu bgasdfq ctdcrl\n" +
            "ruhqq (7)\n" +
            "yekxli (41)\n" +
            "ywrze (33)\n" +
            "jrksg (58)\n" +
            "mkvblbi (43)\n" +
            "suyawzr (47)\n" +
            "yhgutqw (10) -> oybow ctdsj deyxep iyegmn\n" +
            "qucxsqh (83)\n" +
            "iurmaj (40)\n" +
            "ejjgym (69)\n" +
            "jfajopz (76) -> aonpvtr hykmnhl ppavww wfkxhlf\n" +
            "undaxyj (92)\n" +
            "avfsez (81)\n" +
            "gbqig (181) -> qgkaso gtditk\n" +
            "qaqof (130) -> oxerrb afxazvx mhseysh\n" +
            "xdrjmkv (82)\n" +
            "tocdoo (82)\n" +
            "mlztke (233) -> bgjwy lrosl\n" +
            "aymgd (62)\n" +
            "mcnsxuh (143) -> xnqeu xrjrjp qvowcc qazqwkj\n" +
            "afycii (199) -> okqwb mvxqfe\n" +
            "atzuayu (41)\n" +
            "svfgh (99)\n" +
            "tnngtb (52)\n" +
            "hwhhyhh (56)\n" +
            "qrlmd (98) -> xernf klvhv\n" +
            "wnjtvt (11)\n" +
            "wzruwk (82)\n" +
            "luixm (59)\n" +
            "hkntpfd (107) -> pyraep tiunb\n" +
            "mqjpes (12)\n" +
            "pshil (78)\n" +
            "wvisr (137) -> znkqj dwvbnp\n" +
            "slohro (598) -> qhgvoj mdanw zimidd\n" +
            "rdnozh (304) -> lgmjeng llalv\n" +
            "psmvz (15)\n" +
            "zlsrhdz (75)\n" +
            "taaoji (58)\n" +
            "wbqkf (22)\n" +
            "metsfo (253) -> xoabt wbiys\n" +
            "kckevg (7)\n" +
            "hhrlaah (155) -> smjtypd rwqopie\n" +
            "daesbhs (77)\n" +
            "tuyjnby (44)\n" +
            "danfue (32) -> okrnkqa mqjqez gndjq qcizo\n" +
            "ropjtoe (942) -> wpxhphx wrwusvc zarww xymtys\n" +
            "tinitt (240) -> gypuu btsvvyg\n" +
            "kxsefnd (285) -> cmqni pjhoue\n" +
            "yzfnlfl (27)\n" +
            "wpfywy (530) -> mifmz edygy nmfhgq danfue\n" +
            "hwldx (66)\n" +
            "sakmn (74)\n" +
            "ehlwoxs (7524) -> qggjzz zordz phntkf\n" +
            "fekdmb (96)\n" +
            "ziyta (18)\n" +
            "cbdyc (58)\n" +
            "ibushn (41) -> thats nefpbc yvpzbgp vddsv\n" +
            "lcbkylu (732) -> gawbtev aejhrrh zfzpgfw\n" +
            "mhlgi (50)\n" +
            "rptfwu (12)\n" +
            "fkmyndg (50)\n" +
            "tylelk (24) -> drfzng yhonqw wsyiyen dqwocyn qqnroz\n" +
            "azjunml (42)\n" +
            "hfjazyf (80)\n" +
            "nuajwg (86)\n" +
            "cukfipr (40)\n" +
            "pkcpn (90)\n" +
            "guccv (73)\n" +
            "pyfeav (62)\n" +
            "ikeiwjo (157)\n" +
            "hqcwl (19)\n" +
            "xayhv (76)\n" +
            "wemzz (76)\n" +
            "cqupq (88) -> jjvbyf zddlo plmaxee\n" +
            "btrdhk (43)\n" +
            "eirze (41)\n" +
            "litnjrv (1103) -> fxqaw jbqehvt hhrlaah\n" +
            "gveca (66) -> bstqyq imdqhns\n" +
            "wpgziu (88)\n" +
            "vfwwc (61) -> anoza zjhnhz hgdghys\n" +
            "losjvw (61)\n" +
            "zbxopzp (147) -> qaqgap cqfyjm\n" +
            "uksim (24)\n" +
            "uiiqr (1611) -> ysxuvi yryyz dnmsps cqdggj vyevfn dzienj\n" +
            "mifmz (170) -> tgqxadm efqzxka\n" +
            "hkxefzm (40)\n" +
            "ojcpgj (121) -> fpwoels dzyfjvd\n" +
            "xqrnd (35) -> wlodh gbmexj zsratan\n" +
            "ahcba (38)\n" +
            "jnxbxzk (32)\n" +
            "ftthnl (222) -> halwu mdktwy\n" +
            "qjlrpjn (59)\n" +
            "nuwpvd (76)\n" +
            "jnhyc (252) -> lcqed fiwnjv\n" +
            "gmevoe (43)\n" +
            "glumdc (64)\n" +
            "rajiodp (268) -> uldlh rudbmkz\n" +
            "qebkt (95)\n" +
            "vddfzu (67) -> wchtkp aduuei\n" +
            "hcqsg (939) -> zgzxr moeujf xtocem hivsxt\n" +
            "wrwusvc (60) -> bdqnomo objgx\n" +
            "uzoroj (199) -> dvips dkeosz\n" +
            "ujyxvl (54)\n" +
            "nltqkvf (66) -> fwevqj aledrs elvzp\n" +
            "lhjpci (34)\n" +
            "igqup (69)\n" +
            "vszfxh (40)\n" +
            "ztxjb (81)\n" +
            "aibabp (58)\n" +
            "vaqhekv (217) -> pejkmud bkicgcc\n" +
            "wchtkp (65)\n" +
            "ycxyxg (91)\n" +
            "rgpazuy (44) -> waxvx uckyywt\n" +
            "bppdgwm (78)\n" +
            "csxdpl (56)\n" +
            "vxjvov (68) -> tocdoo jpxgvjl\n" +
            "vuckhv (87)\n" +
            "wnqny (56)\n" +
            "kcorlw (86)\n" +
            "jlvakq (239) -> ngtpz xplsuaq\n" +
            "tcfmra (96)\n" +
            "twxwam (8975) -> qwtvro osipmuv cldldxp\n" +
            "xhang (48)\n" +
            "qneggdm (169) -> iurmaj faqsp\n" +
            "umuur (86)\n" +
            "tuyon (90)\n" +
            "aqoik (53)\n" +
            "oldoxo (75)\n" +
            "rjjeggt (44)\n" +
            "fdklcbu (70)\n" +
            "tslfayy (41)\n" +
            "zpjju (68) -> ncffht akmsaq\n" +
            "xijkpj (38)\n" +
            "xfmneu (89)\n" +
            "fdgccyg (24)\n" +
            "qkllvda (8)\n" +
            "zhubam (12)\n" +
            "emreip (94)\n" +
            "euypgtx (80)\n" +
            "tbwieh (108) -> uglla iyqcty pgtmio\n" +
            "mlkddpw (34)\n" +
            "zxphdt (5)\n" +
            "ohbzmqz (11)\n" +
            "dylrpo (69)\n" +
            "zjuupn (51) -> sibko mlighq wogrc\n" +
            "xykvys (160) -> iemgv joees\n" +
            "nxwtdg (51) -> tcfmra nvkhow fekdmb xgufltj\n" +
            "mlighq (27)\n" +
            "abspab (54)\n" +
            "fzcerr (10) -> zhnjnvg bncmd\n" +
            "fxhlrok (69) -> dyxzd rajiodp hztzf apexe\n" +
            "xvhpqmh (47) -> tuyjnby aygltsd\n" +
            "nafvoj (127) -> aqoik tapirho kyizmdu\n" +
            "bkfbj (61)\n" +
            "hmyuwix (50) -> bpmrgr soiza mkbjgur\n" +
            "ilkhnhw (96)\n" +
            "fkbivys (69)\n" +
            "ikclk (77)\n" +
            "ysxuvi (249)\n" +
            "sppgjfx (530) -> bszaj ozzxjr ivfffiz cdqkuuw\n" +
            "dfghz (64)\n" +
            "bxwtlj (214) -> khkaq pkdeoh dvvlx\n" +
            "uvexl (205) -> ftohrkw fknai\n" +
            "xrjrjp (30)\n" +
            "oopiw (214)\n" +
            "yesozb (55)\n" +
            "wochkc (88)\n" +
            "dzyfjvd (35)\n" +
            "efqzxka (71)\n" +
            "hdjlp (55)\n" +
            "pbmni (69)\n" +
            "afcsq (190) -> zlvgiq wemzz\n" +
            "hsykei (80)\n" +
            "swjcx (79) -> nbjrv ytfnug\n" +
            "yanwn (95)\n" +
            "orxgo (99)\n" +
            "tcvpst (22)\n" +
            "xnfybs (41)\n" +
            "ctqym (59)\n" +
            "hwdkwn (27)\n" +
            "bvelsl (54)\n" +
            "gkegoh (51)\n" +
            "cbacfi (60)\n" +
            "gjihp (35)\n" +
            "hgdghys (1528) -> acpwe yvttt xbowtoi hmrrarb qneggdm\n" +
            "aejhrrh (281) -> gkskqqb acgiwii\n" +
            "pzmmc (83) -> kmemzft ewtqg\n" +
            "ffrgif (6) -> bpmus vuckhv\n" +
            "naacbhr (39)\n" +
            "qeksx (73)\n" +
            "ncymzc (202) -> holcno lmueep\n" +
            "gfghu (73)\n" +
            "qbncqqm (76)\n" +
            "qqkwjoy (297) -> iuagzo nuvrtnk\n" +
            "sohohlc (697) -> gmeqmy xstgov ncymzc\n" +
            "zhnjnvg (95)\n" +
            "blstaec (115) -> kxcid qummd\n" +
            "uhmmouc (74)\n" +
            "tfphsaq (1875) -> sndfkkd vddfzu xorbfm\n" +
            "phntkf (31) -> jjdfk sqcet iueqa\n" +
            "xfkpfqd (236)\n" +
            "tujrz (62)\n" +
            "sfxvp (167) -> uvfou kasozsw jfajopz\n" +
            "lyaqynn (43)\n" +
            "bfqotji (55)\n" +
            "jbkek (164) -> txznlay fkzxmb\n" +
            "kqvsah (95)\n" +
            "zffoytm (85)\n" +
            "bpvit (184) -> tgexl qbncqqm\n" +
            "ocuhfpd (95)\n" +
            "xhqrf (73)\n" +
            "jtgcmc (47) -> aqfemi undug bpznnqh mmjpziu\n" +
            "rdthc (173) -> zfaxas wfpxk jwmjagj\n" +
            "hrbukg (6404) -> vlszzu irgumpr xwunxz\n" +
            "sndfkkd (83) -> yldsmt drswab\n" +
            "znkqj (80)\n" +
            "xhubgcl (254) -> xnqznos cbaah\n" +
            "epeain (16)\n" +
            "jbqehvt (225)\n" +
            "dobqmg (159) -> ejjgym igqup\n" +
            "fguhavr (82)\n" +
            "dtakrnu (20)\n" +
            "ozzxjr (254) -> ojzpzsa enmoyyj nqzlzs\n" +
            "sqwovza (82)\n" +
            "hqpkdyb (106) -> bvviqc jxcxv ozugcs\n" +
            "ybfqzep (82)\n" +
            "bpmrgr (34)\n" +
            "qcldyng (32)\n" +
            "sbsfo (98)\n" +
            "saxar (88)\n" +
            "xucrab (63)\n" +
            "mdktwy (66)\n" +
            "nkegq (69)\n" +
            "gawbtev (100) -> jleqdi dylrpo zxdhxrb\n" +
            "htgvzw (180) -> rpanfr zdaorg\n" +
            "fojnd (32)\n" +
            "yaera (143) -> mpwlly gxzxapn\n" +
            "vlaowv (226) -> dxzahps mtfqemm\n" +
            "lwujegj (101) -> emreip ujnas\n" +
            "rtwur (311) -> shgcr euoqdcd\n" +
            "dniub (19)\n" +
            "qaqgap (68)\n" +
            "oucqw (7596) -> qrlmd gwpzvb aywrlw\n" +
            "nesoknh (82)\n" +
            "rpzit (59)\n" +
            "uwoyjsd (83)\n" +
            "rawfw (68)\n" +
            "bnsqqv (38)\n" +
            "sgvaf (43) -> ihmqbiu mweox zkaqnra uiiqr athdvrh qqmpq jfnknli\n" +
            "ysmqsps (61) -> hfjazyf lyorl mhassg euypgtx\n" +
            "facjth (57) -> wvaynsl ygykyu bhaebe qcsfpn\n" +
            "gdvqsyp (388) -> zdiygz ksbjftc uekiz\n" +
            "bsnxzz (55)\n" +
            "qyqthsz (5) -> nkegq jrjkj\n" +
            "xcjxzq (1306) -> hmjzw ylmwjuo xupkjdt\n" +
            "nbykdlk (339) -> gmtsea qahfrp\n" +
            "acgiwii (13)\n" +
            "xquzvw (41)\n" +
            "kdrke (81)\n" +
            "bpznnqh (38)\n" +
            "zhckae (58)\n" +
            "ypzqp (1219) -> jewrs juytoy\n" +
            "vrqdv (29)\n" +
            "klcuumi (42) -> swqgxh rtzodmx xmendwz\n" +
            "bsqpcne (362) -> xulpd ixwoprg rqqxoou xykvys nfchpk\n" +
            "oxerrb (49)\n" +
            "hivsxt (147) -> bipyp botmw\n" +
            "kmyvyx (90)\n" +
            "nfkbhas (15)\n" +
            "hkcghm (76)\n" +
            "kqokslj (80)\n" +
            "djxvowe (56)\n" +
            "jypccpq (46)\n" +
            "yktmvtf (27)\n" +
            "dezgi (20)\n" +
            "bojjcl (31)\n" +
            "zsancei (75)\n" +
            "jnmgovh (86)\n" +
            "buyazh (1149) -> jrksg zhckae\n" +
            "sppxgv (276) -> hgblqo xpqnuh\n" +
            "cguzndh (75)\n" +
            "shgcr (62)\n" +
            "hmrrarb (53) -> wadeqe floca\n" +
            "lmueep (13)\n" +
            "ntugl (44)\n" +
            "ftatt (92)\n" +
            "pgnbhl (210) -> qovcwth bhxmn ibagnjs\n" +
            "qsods (55)\n" +
            "xngnhi (841) -> jfclt fpnjjy wjkqpqr\n" +
            "relztcy (22)\n" +
            "vtphqb (237)\n" +
            "qahfrp (8)\n" +
            "bqppw (269)\n" +
            "hxowycm (16) -> okmwjoa undaxyj\n" +
            "oojlo (111) -> losjvw ekpvnh\n" +
            "fgbsxh (268)\n" +
            "mmotdue (113) -> relztcy qwtheza\n" +
            "tienxkv (358) -> rqbjjuo wdgfw\n" +
            "qwfosq (35) -> aunrdo ntadc\n" +
            "anoza (37) -> bdzkzv dzugjhb hgltuwc odmmo tienxkv yowbd\n" +
            "kioxu (159) -> qkdiej kqfob\n" +
            "ybjld (24)\n" +
            "juytoy (80)\n" +
            "xstgov (206) -> wnjtvt bnqutso\n" +
            "tapirho (53)\n" +
            "vjhwn (1738) -> xrmslfs djejdy oopiw\n" +
            "iroikgp (75) -> vqbfan gkegoh\n" +
            "jtfdy (19)\n" +
            "ybqzq (363) -> vpsls bbsvfl isoayc\n" +
            "pqsfee (82)\n" +
            "bhxmn (59)\n" +
            "amhug (73)\n" +
            "yxzdn (19)\n" +
            "wvaynsl (85)\n" +
            "hrhfd (37)\n" +
            "yrbpdq (57)\n" +
            "ipppjn (62)\n" +
            "ygnlbv (88)\n" +
            "zjhnhz (2113) -> fsose tbwieh myhgys nltqkvf\n" +
            "facddx (151) -> hwldx ydgusm\n" +
            "gnbmz (89)\n" +
            "bmxoqy (17)\n" +
            "pyhohkx (17) -> nghcpr wpgziu\n" +
            "sqnfn (235) -> ztxjb noqmsh\n" +
            "gzqutgv (185) -> gqwfi yenbb reqlm krquje\n" +
            "tgqxadm (71)\n" +
            "qjdqn (27) -> wzruwk eegwdp\n" +
            "mvldvib (44)\n" +
            "gbmexj (39)\n" +
            "ppedet (34) -> qhfoy lpgtx xucrab oioqg\n" +
            "ctdcrl (38) -> kufceqa qebkt ocuhfpd isvfa\n" +
            "bhaebe (85)\n" +
            "amooqlb (53)\n" +
            "tcaex (115) -> cvxcr mxikfk xzfrad tlwqwlk\n" +
            "uoenrx (59)\n" +
            "ewvlay (34)\n" +
            "zkwzctg (98)\n" +
            "qkjed (32)\n" +
            "jewrs (80)\n" +
            "snquxtz (53) -> dzrywb hoilkqz\n" +
            "miidkpe (96)\n" +
            "hgltuwc (316) -> ptyuh wfixt\n" +
            "oybow (58)\n" +
            "dtsdw (61)\n" +
            "qfzyvjr (156) -> ehclf nmvki\n" +
            "ymerus (46)\n" +
            "cbefqk (65) -> fgzwvuy yaawixo\n" +
            "nyeur (17)\n" +
            "baimp (69)";

    public static void main(String[] args) {
        RecursiveCircus rc = new RecursiveCircus(DATA);
        System.out.println("part 1: " + rc.calculate());
    }

}
