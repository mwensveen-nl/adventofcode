package nl.mwensveen.adventofcode.year_2017.day_5;

public class TwistyTrampolinesSolution {

	public static void main(String[] args) {
		TwistyTrampolines twistyTrampolines = new TwistyTrampolines("0\n" + 
				"0\n" + 
				"1\n" + 
				"2\n" + 
				"0\n" + 
				"1\n" + 
				"0\n" + 
				"2\n" + 
				"-2\n" + 
				"-6\n" + 
				"0\n" + 
				"-7\n" + 
				"2\n" + 
				"2\n" + 
				"1\n" + 
				"-2\n" + 
				"1\n" + 
				"1\n" + 
				"-11\n" + 
				"-14\n" + 
				"-16\n" + 
				"-14\n" + 
				"-12\n" + 
				"-5\n" + 
				"-2\n" + 
				"-21\n" + 
				"-15\n" + 
				"-9\n" + 
				"0\n" + 
				"-13\n" + 
				"-4\n" + 
				"-19\n" + 
				"-31\n" + 
				"1\n" + 
				"-15\n" + 
				"-1\n" + 
				"-23\n" + 
				"-18\n" + 
				"0\n" + 
				"-18\n" + 
				"-11\n" + 
				"-21\n" + 
				"-6\n" + 
				"2\n" + 
				"-38\n" + 
				"2\n" + 
				"-38\n" + 
				"-40\n" + 
				"-15\n" + 
				"-2\n" + 
				"-23\n" + 
				"-42\n" + 
				"-23\n" + 
				"-36\n" + 
				"-37\n" + 
				"-34\n" + 
				"-26\n" + 
				"-51\n" + 
				"-14\n" + 
				"-8\n" + 
				"-56\n" + 
				"-11\n" + 
				"-14\n" + 
				"-40\n" + 
				"-39\n" + 
				"-26\n" + 
				"-35\n" + 
				"-48\n" + 
				"-52\n" + 
				"-18\n" + 
				"-16\n" + 
				"-11\n" + 
				"-38\n" + 
				"-4\n" + 
				"-70\n" + 
				"-20\n" + 
				"-10\n" + 
				"-37\n" + 
				"-75\n" + 
				"-33\n" + 
				"-39\n" + 
				"-37\n" + 
				"-74\n" + 
				"-17\n" + 
				"-83\n" + 
				"-13\n" + 
				"-75\n" + 
				"-56\n" + 
				"-44\n" + 
				"-40\n" + 
				"-20\n" + 
				"-18\n" + 
				"-74\n" + 
				"-32\n" + 
				"-48\n" + 
				"-11\n" + 
				"-80\n" + 
				"-88\n" + 
				"-33\n" + 
				"-67\n" + 
				"-96\n" + 
				"-67\n" + 
				"-49\n" + 
				"-55\n" + 
				"-101\n" + 
				"-8\n" + 
				"-77\n" + 
				"-33\n" + 
				"-93\n" + 
				"-22\n" + 
				"-21\n" + 
				"-99\n" + 
				"-33\n" + 
				"-12\n" + 
				"-111\n" + 
				"-105\n" + 
				"-77\n" + 
				"-76\n" + 
				"-90\n" + 
				"-63\n" + 
				"-76\n" + 
				"-55\n" + 
				"-65\n" + 
				"-106\n" + 
				"-56\n" + 
				"-93\n" + 
				"-121\n" + 
				"-31\n" + 
				"-86\n" + 
				"-102\n" + 
				"-116\n" + 
				"-120\n" + 
				"-17\n" + 
				"-95\n" + 
				"-110\n" + 
				"-128\n" + 
				"-122\n" + 
				"-135\n" + 
				"-133\n" + 
				"-124\n" + 
				"-50\n" + 
				"-32\n" + 
				"-86\n" + 
				"-11\n" + 
				"-127\n" + 
				"-42\n" + 
				"-9\n" + 
				"-41\n" + 
				"-28\n" + 
				"-93\n" + 
				"-13\n" + 
				"-16\n" + 
				"-8\n" + 
				"-138\n" + 
				"-111\n" + 
				"-103\n" + 
				"-25\n" + 
				"-22\n" + 
				"-133\n" + 
				"-52\n" + 
				"-27\n" + 
				"-6\n" + 
				"-67\n" + 
				"-72\n" + 
				"-115\n" + 
				"-133\n" + 
				"-146\n" + 
				"-46\n" + 
				"-128\n" + 
				"-99\n" + 
				"-115\n" + 
				"-16\n" + 
				"-113\n" + 
				"-105\n" + 
				"1\n" + 
				"-76\n" + 
				"-2\n" + 
				"1\n" + 
				"-66\n" + 
				"-164\n" + 
				"-87\n" + 
				"-8\n" + 
				"-92\n" + 
				"-180\n" + 
				"-137\n" + 
				"-39\n" + 
				"-127\n" + 
				"-124\n" + 
				"-66\n" + 
				"-96\n" + 
				"-185\n" + 
				"-13\n" + 
				"-65\n" + 
				"-178\n" + 
				"-16\n" + 
				"-32\n" + 
				"-24\n" + 
				"-84\n" + 
				"-49\n" + 
				"-7\n" + 
				"-198\n" + 
				"-101\n" + 
				"-119\n" + 
				"-187\n" + 
				"-71\n" + 
				"-125\n" + 
				"-130\n" + 
				"-72\n" + 
				"-130\n" + 
				"-43\n" + 
				"-136\n" + 
				"-171\n" + 
				"-32\n" + 
				"-210\n" + 
				"-69\n" + 
				"-195\n" + 
				"-207\n" + 
				"-197\n" + 
				"-190\n" + 
				"-117\n" + 
				"-196\n" + 
				"-143\n" + 
				"-128\n" + 
				"-155\n" + 
				"-160\n" + 
				"-53\n" + 
				"-205\n" + 
				"-15\n" + 
				"-86\n" + 
				"-227\n" + 
				"-128\n" + 
				"-115\n" + 
				"-58\n" + 
				"-96\n" + 
				"-52\n" + 
				"-100\n" + 
				"-41\n" + 
				"-84\n" + 
				"-61\n" + 
				"-50\n" + 
				"-91\n" + 
				"-158\n" + 
				"-30\n" + 
				"-230\n" + 
				"-125\n" + 
				"-177\n" + 
				"-181\n" + 
				"-47\n" + 
				"-43\n" + 
				"-241\n" + 
				"-52\n" + 
				"-102\n" + 
				"-161\n" + 
				"-16\n" + 
				"-130\n" + 
				"-21\n" + 
				"-22\n" + 
				"-249\n" + 
				"-78\n" + 
				"-101\n" + 
				"-51\n" + 
				"-229\n" + 
				"-148\n" + 
				"-132\n" + 
				"-213\n" + 
				"-264\n" + 
				"-175\n" + 
				"-128\n" + 
				"-102\n" + 
				"-26\n" + 
				"-86\n" + 
				"-84\n" + 
				"-100\n" + 
				"-132\n" + 
				"-228\n" + 
				"-118\n" + 
				"-46\n" + 
				"-77\n" + 
				"-230\n" + 
				"-98\n" + 
				"-193\n" + 
				"-191\n" + 
				"-142\n" + 
				"-193\n" + 
				"-183\n" + 
				"-58\n" + 
				"-59\n" + 
				"-254\n" + 
				"-256\n" + 
				"-108\n" + 
				"-12\n" + 
				"-46\n" + 
				"-11\n" + 
				"-143\n" + 
				"-22\n" + 
				"-121\n" + 
				"-68\n" + 
				"-282\n" + 
				"-94\n" + 
				"-22\n" + 
				"-172\n" + 
				"-246\n" + 
				"-174\n" + 
				"-76\n" + 
				"-3\n" + 
				"-117\n" + 
				"-237\n" + 
				"-258\n" + 
				"-29\n" + 
				"-105\n" + 
				"-32\n" + 
				"-177\n" + 
				"-125\n" + 
				"-70\n" + 
				"-176\n" + 
				"-113\n" + 
				"-152\n" + 
				"-227\n" + 
				"-298\n" + 
				"-199\n" + 
				"-179\n" + 
				"-162\n" + 
				"-241\n" + 
				"-230\n" + 
				"-8\n" + 
				"-202\n" + 
				"-296\n" + 
				"-194\n" + 
				"-82\n" + 
				"-188\n" + 
				"-136\n" + 
				"-24\n" + 
				"-171\n" + 
				"-185\n" + 
				"-272\n" + 
				"-124\n" + 
				"-306\n" + 
				"-230\n" + 
				"-249\n" + 
				"-64\n" + 
				"-139\n" + 
				"-143\n" + 
				"-293\n" + 
				"-218\n" + 
				"-167\n" + 
				"-208\n" + 
				"-254\n" + 
				"-171\n" + 
				"-119\n" + 
				"-82\n" + 
				"-284\n" + 
				"-262\n" + 
				"-252\n" + 
				"-92\n" + 
				"-230\n" + 
				"-193\n" + 
				"-173\n" + 
				"-269\n" + 
				"-173\n" + 
				"-13\n" + 
				"0\n" + 
				"-148\n" + 
				"-151\n" + 
				"-241\n" + 
				"-120\n" + 
				"-20\n" + 
				"-22\n" + 
				"-218\n" + 
				"-6\n" + 
				"-314\n" + 
				"-347\n" + 
				"-58\n" + 
				"-180\n" + 
				"-242\n" + 
				"-333\n" + 
				"-247\n" + 
				"-67\n" + 
				"-137\n" + 
				"-102\n" + 
				"-32\n" + 
				"-102\n" + 
				"-88\n" + 
				"-42\n" + 
				"-284\n" + 
				"-109\n" + 
				"-281\n" + 
				"-43\n" + 
				"-63\n" + 
				"-205\n" + 
				"-268\n" + 
				"-273\n" + 
				"-235\n" + 
				"-119\n" + 
				"-185\n" + 
				"-62\n" + 
				"-56\n" + 
				"-260\n" + 
				"-47\n" + 
				"-353\n" + 
				"-123\n" + 
				"-312\n" + 
				"0\n" + 
				"-76\n" + 
				"-352\n" + 
				"-365\n" + 
				"-284\n" + 
				"-105\n" + 
				"-62\n" + 
				"-165\n" + 
				"-292\n" + 
				"-5\n" + 
				"-46\n" + 
				"-31\n" + 
				"-116\n" + 
				"-147\n" + 
				"-34\n" + 
				"-149\n" + 
				"-79\n" + 
				"-139\n" + 
				"-132\n" + 
				"-84\n" + 
				"-58\n" + 
				"-130\n" + 
				"-125\n" + 
				"-188\n" + 
				"-227\n" + 
				"-2\n" + 
				"-220\n" + 
				"-88\n" + 
				"-96\n" + 
				"-38\n" + 
				"-308\n" + 
				"-214\n" + 
				"-357\n" + 
				"-19\n" + 
				"-410\n" + 
				"-292\n" + 
				"-150\n" + 
				"-151\n" + 
				"1\n" + 
				"-252\n" + 
				"-172\n" + 
				"-414\n" + 
				"-15\n" + 
				"-207\n" + 
				"-184\n" + 
				"-286\n" + 
				"-161\n" + 
				"-55\n" + 
				"-158\n" + 
				"-330\n" + 
				"-53\n" + 
				"-310\n" + 
				"-295\n" + 
				"-248\n" + 
				"-126\n" + 
				"-425\n" + 
				"-10\n" + 
				"-289\n" + 
				"-148\n" + 
				"-146\n" + 
				"-436\n" + 
				"-279\n" + 
				"-48\n" + 
				"-321\n" + 
				"-196\n" + 
				"-162\n" + 
				"-55\n" + 
				"-125\n" + 
				"-62\n" + 
				"-381\n" + 
				"-337\n" + 
				"-85\n" + 
				"-428\n" + 
				"-470\n" + 
				"-180\n" + 
				"-392\n" + 
				"-450\n" + 
				"-376\n" + 
				"-73\n" + 
				"-206\n" + 
				"-115\n" + 
				"-289\n" + 
				"-318\n" + 
				"-22\n" + 
				"-200\n" + 
				"-176\n" + 
				"-410\n" + 
				"-380\n" + 
				"-470\n" + 
				"-418\n" + 
				"-163\n" + 
				"-424\n" + 
				"-288\n" + 
				"-374\n" + 
				"-358\n" + 
				"-386\n" + 
				"-340\n" + 
				"-403\n" + 
				"-81\n" + 
				"-7\n" + 
				"-378\n" + 
				"1\n" + 
				"-320\n" + 
				"-323\n" + 
				"-288\n" + 
				"-439\n" + 
				"-437\n" + 
				"-90\n" + 
				"-159\n" + 
				"-379\n" + 
				"-69\n" + 
				"-236\n" + 
				"-168\n" + 
				"-232\n" + 
				"-232\n" + 
				"-42\n" + 
				"-257\n" + 
				"-437\n" + 
				"-40\n" + 
				"-390\n" + 
				"-241\n" + 
				"-54\n" + 
				"-247\n" + 
				"-76\n" + 
				"-325\n" + 
				"-351\n" + 
				"-259\n" + 
				"-328\n" + 
				"-283\n" + 
				"-5\n" + 
				"-169\n" + 
				"-114\n" + 
				"-252\n" + 
				"-131\n" + 
				"-223\n" + 
				"-446\n" + 
				"-482\n" + 
				"-7\n" + 
				"-285\n" + 
				"-486\n" + 
				"-260\n" + 
				"-421\n" + 
				"-498\n" + 
				"-32\n" + 
				"-182\n" + 
				"-317\n" + 
				"-201\n" + 
				"-370\n" + 
				"-518\n" + 
				"-129\n" + 
				"-359\n" + 
				"-67\n" + 
				"-209\n" + 
				"-541\n" + 
				"-323\n" + 
				"-132\n" + 
				"-197\n" + 
				"-70\n" + 
				"-171\n" + 
				"-258\n" + 
				"-372\n" + 
				"-228\n" + 
				"-4\n" + 
				"-360\n" + 
				"-144\n" + 
				"-307\n" + 
				"-226\n" + 
				"-533\n" + 
				"-435\n" + 
				"-318\n" + 
				"-284\n" + 
				"-284\n" + 
				"-150\n" + 
				"-539\n" + 
				"-46\n" + 
				"-81\n" + 
				"-144\n" + 
				"-188\n" + 
				"-264\n" + 
				"-136\n" + 
				"-138\n" + 
				"-106\n" + 
				"-65\n" + 
				"-262\n" + 
				"-250\n" + 
				"-176\n" + 
				"-261\n" + 
				"-112\n" + 
				"-227\n" + 
				"-304\n" + 
				"-159\n" + 
				"-425\n" + 
				"-117\n" + 
				"-441\n" + 
				"-111\n" + 
				"-468\n" + 
				"-2\n" + 
				"-84\n" + 
				"-197\n" + 
				"1\n" + 
				"-575\n" + 
				"-305\n" + 
				"-401\n" + 
				"-114\n" + 
				"-143\n" + 
				"-180\n" + 
				"-16\n" + 
				"-450\n" + 
				"-24\n" + 
				"-357\n" + 
				"-104\n" + 
				"-434\n" + 
				"-435\n" + 
				"-345\n" + 
				"-247\n" + 
				"-484\n" + 
				"-282\n" + 
				"-263\n" + 
				"-389\n" + 
				"-463\n" + 
				"-178\n" + 
				"-144\n" + 
				"-256\n" + 
				"-94\n" + 
				"-522\n" + 
				"-302\n" + 
				"-524\n" + 
				"-309\n" + 
				"-275\n" + 
				"-350\n" + 
				"-596\n" + 
				"-462\n" + 
				"-317\n" + 
				"-543\n" + 
				"-8\n" + 
				"-374\n" + 
				"-404\n" + 
				"-302\n" + 
				"-610\n" + 
				"-111\n" + 
				"-358\n" + 
				"2\n" + 
				"-353\n" + 
				"-397\n" + 
				"-165\n" + 
				"-324\n" + 
				"-574\n" + 
				"-618\n" + 
				"-168\n" + 
				"-636\n" + 
				"-389\n" + 
				"-609\n" + 
				"-54\n" + 
				"-121\n" + 
				"-256\n" + 
				"-604\n" + 
				"-588\n" + 
				"-454\n" + 
				"-100\n" + 
				"-212\n" + 
				"-65\n" + 
				"-300\n" + 
				"-592\n" + 
				"-43\n" + 
				"-230\n" + 
				"-652\n" + 
				"-638\n" + 
				"-67\n" + 
				"-499\n" + 
				"-614\n" + 
				"-419\n" + 
				"-577\n" + 
				"-96\n" + 
				"-257\n" + 
				"-519\n" + 
				"-458\n" + 
				"-14\n" + 
				"-26\n" + 
				"-370\n" + 
				"-187\n" + 
				"-319\n" + 
				"-528\n" + 
				"-436\n" + 
				"-87\n" + 
				"-673\n" + 
				"-535\n" + 
				"-473\n" + 
				"-670\n" + 
				"-594\n" + 
				"-589\n" + 
				"-629\n" + 
				"-180\n" + 
				"-13\n" + 
				"-668\n" + 
				"-369\n" + 
				"-679\n" + 
				"-587\n" + 
				"-624\n" + 
				"-123\n" + 
				"-363\n" + 
				"-241\n" + 
				"-343\n" + 
				"-259\n" + 
				"-123\n" + 
				"-319\n" + 
				"-608\n" + 
				"-470\n" + 
				"-336\n" + 
				"-291\n" + 
				"-676\n" + 
				"-535\n" + 
				"-226\n" + 
				"-11\n" + 
				"-224\n" + 
				"-43\n" + 
				"-30\n" + 
				"-605\n" + 
				"-670\n" + 
				"-544\n" + 
				"-248\n" + 
				"-609\n" + 
				"-144\n" + 
				"-328\n" + 
				"-177\n" + 
				"-360\n" + 
				"-628\n" + 
				"-51\n" + 
				"-724\n" + 
				"-407\n" + 
				"-625\n" + 
				"-433\n" + 
				"-192\n" + 
				"-455\n" + 
				"-603\n" + 
				"-581\n" + 
				"-33\n" + 
				"-696\n" + 
				"-160\n" + 
				"-464\n" + 
				"-510\n" + 
				"-3\n" + 
				"-144\n" + 
				"-113\n" + 
				"-87\n" + 
				"-519\n" + 
				"-263\n" + 
				"-161\n" + 
				"-94\n" + 
				"-716\n" + 
				"-484\n" + 
				"-509\n" + 
				"-615\n" + 
				"-373\n" + 
				"-734\n" + 
				"-686\n" + 
				"-732\n" + 
				"-395\n" + 
				"-163\n" + 
				"-432\n" + 
				"-26\n" + 
				"-716\n" + 
				"-599\n" + 
				"-596\n" + 
				"-648\n" + 
				"-91\n" + 
				"-716\n" + 
				"-540\n" + 
				"-429\n" + 
				"-456\n" + 
				"-744\n" + 
				"-344\n" + 
				"-298\n" + 
				"-689\n" + 
				"-428\n" + 
				"-119\n" + 
				"-323\n" + 
				"-196\n" + 
				"-41\n" + 
				"-602\n" + 
				"-724\n" + 
				"-413\n" + 
				"-444\n" + 
				"-614\n" + 
				"-331\n" + 
				"-697\n" + 
				"-115\n" + 
				"-7\n" + 
				"-409\n" + 
				"-272\n" + 
				"-672\n" + 
				"-224\n" + 
				"-732\n" + 
				"-203\n" + 
				"-37\n" + 
				"-397\n" + 
				"-794\n" + 
				"-161\n" + 
				"-512\n" + 
				"-664\n" + 
				"-193\n" + 
				"-245\n" + 
				"-490\n" + 
				"-439\n" + 
				"-696\n" + 
				"-661\n" + 
				"-717\n" + 
				"-424\n" + 
				"-308\n" + 
				"-481\n" + 
				"-215\n" + 
				"-658\n" + 
				"-705\n" + 
				"-389\n" + 
				"-90\n" + 
				"-619\n" + 
				"-297\n" + 
				"-670\n" + 
				"-125\n" + 
				"-119\n" + 
				"-268\n" + 
				"-553\n" + 
				"-227\n" + 
				"-733\n" + 
				"-142\n" + 
				"-333\n" + 
				"-52\n" + 
				"-609\n" + 
				"-795\n" + 
				"-422\n" + 
				"-202\n" + 
				"-579\n" + 
				"-397\n" + 
				"-431\n" + 
				"-561\n" + 
				"-140\n" + 
				"-467\n" + 
				"-688\n" + 
				"-486\n" + 
				"-493\n" + 
				"-279\n" + 
				"-457\n" + 
				"-295\n" + 
				"-181\n" + 
				"-823\n" + 
				"-808\n" + 
				"-495\n" + 
				"-620\n" + 
				"-652\n" + 
				"-80\n" + 
				"-22\n" + 
				"-26\n" + 
				"-769\n" + 
				"0\n" + 
				"-439\n" + 
				"-31\n" + 
				"-458\n" + 
				"-5\n" + 
				"-221\n" + 
				"-675\n" + 
				"-443\n" + 
				"-809\n" + 
				"-845\n" + 
				"-234\n" + 
				"-429\n" + 
				"-425\n" + 
				"-754\n" + 
				"-820\n" + 
				"-442\n" + 
				"-561\n" + 
				"-513\n" + 
				"-462\n" + 
				"-840\n" + 
				"-596\n" + 
				"-113\n" + 
				"-736\n" + 
				"-12\n" + 
				"-123\n" + 
				"-747\n" + 
				"-735\n" + 
				"-732\n" + 
				"-209\n" + 
				"-478\n" + 
				"-504\n" + 
				"-784\n" + 
				"-522\n" + 
				"-257\n" + 
				"-695\n" + 
				"-676\n" + 
				"-331\n" + 
				"-767\n" + 
				"-801\n" + 
				"-128\n" + 
				"-571\n" + 
				"-683\n" + 
				"-757\n" + 
				"-475\n" + 
				"-749\n" + 
				"-53\n" + 
				"-366\n" + 
				"-795\n" + 
				"-562\n" + 
				"-632\n" + 
				"-284\n" + 
				"-488\n" + 
				"-692\n" + 
				"-368\n" + 
				"-883\n" + 
				"-542\n" + 
				"-745\n" + 
				"-10\n" + 
				"-693\n" + 
				"-752\n" + 
				"-136\n" + 
				"-736\n" + 
				"-347\n" + 
				"-855\n" + 
				"-521\n" + 
				"-151\n" + 
				"-324\n" + 
				"-126\n" + 
				"-678\n" + 
				"-28\n" + 
				"-875\n" + 
				"-832\n" + 
				"-474\n" + 
				"-657\n" + 
				"-569\n" + 
				"-518\n" + 
				"-642\n" + 
				"-351\n" + 
				"-850\n" + 
				"-45\n" + 
				"-383\n" + 
				"-362\n" + 
				"-655\n" + 
				"-590\n" + 
				"-184\n" + 
				"-543\n" + 
				"-563\n" + 
				"-631\n" + 
				"-165\n" + 
				"-607\n" + 
				"-732\n" + 
				"-450\n" + 
				"-219\n" + 
				"-774\n" + 
				"-461\n" + 
				"-823\n" + 
				"-651\n" + 
				"-48\n" + 
				"-750\n" + 
				"-246\n" + 
				"-341\n" + 
				"-805\n" + 
				"-620\n" + 
				"-425\n" + 
				"-696\n" + 
				"-874\n" + 
				"-502\n" + 
				"-186\n" + 
				"-143\n" + 
				"-77\n" + 
				"-452\n" + 
				"-710\n" + 
				"-103\n" + 
				"-836\n" + 
				"-824\n" + 
				"-775\n" + 
				"-108\n" + 
				"-823\n" + 
				"-937\n" + 
				"-969\n" + 
				"-392\n" + 
				"-17\n" + 
				"-725\n" + 
				"-226\n" + 
				"-441\n" + 
				"-489\n" + 
				"-669\n" + 
				"-665\n" + 
				"-182\n" + 
				"-625\n" + 
				"-905\n" + 
				"-523\n" + 
				"-925\n" + 
				"-573\n" + 
				"-821\n" + 
				"-786\n" + 
				"-734\n" + 
				"-21\n" + 
				"-819\n" + 
				"-181\n" + 
				"-342\n" + 
				"-625\n" + 
				"-12\n" + 
				"-705\n" + 
				"-275\n" + 
				"-756\n" + 
				"-79" );
		System.out.println(twistyTrampolines.calculate());

	
		TwistyTrampolinesStranger twistyTrampolinesStranger = new TwistyTrampolinesStranger("0\n" + 
				"0\n" + 
				"1\n" + 
				"2\n" + 
				"0\n" + 
				"1\n" + 
				"0\n" + 
				"2\n" + 
				"-2\n" + 
				"-6\n" + 
				"0\n" + 
				"-7\n" + 
				"2\n" + 
				"2\n" + 
				"1\n" + 
				"-2\n" + 
				"1\n" + 
				"1\n" + 
				"-11\n" + 
				"-14\n" + 
				"-16\n" + 
				"-14\n" + 
				"-12\n" + 
				"-5\n" + 
				"-2\n" + 
				"-21\n" + 
				"-15\n" + 
				"-9\n" + 
				"0\n" + 
				"-13\n" + 
				"-4\n" + 
				"-19\n" + 
				"-31\n" + 
				"1\n" + 
				"-15\n" + 
				"-1\n" + 
				"-23\n" + 
				"-18\n" + 
				"0\n" + 
				"-18\n" + 
				"-11\n" + 
				"-21\n" + 
				"-6\n" + 
				"2\n" + 
				"-38\n" + 
				"2\n" + 
				"-38\n" + 
				"-40\n" + 
				"-15\n" + 
				"-2\n" + 
				"-23\n" + 
				"-42\n" + 
				"-23\n" + 
				"-36\n" + 
				"-37\n" + 
				"-34\n" + 
				"-26\n" + 
				"-51\n" + 
				"-14\n" + 
				"-8\n" + 
				"-56\n" + 
				"-11\n" + 
				"-14\n" + 
				"-40\n" + 
				"-39\n" + 
				"-26\n" + 
				"-35\n" + 
				"-48\n" + 
				"-52\n" + 
				"-18\n" + 
				"-16\n" + 
				"-11\n" + 
				"-38\n" + 
				"-4\n" + 
				"-70\n" + 
				"-20\n" + 
				"-10\n" + 
				"-37\n" + 
				"-75\n" + 
				"-33\n" + 
				"-39\n" + 
				"-37\n" + 
				"-74\n" + 
				"-17\n" + 
				"-83\n" + 
				"-13\n" + 
				"-75\n" + 
				"-56\n" + 
				"-44\n" + 
				"-40\n" + 
				"-20\n" + 
				"-18\n" + 
				"-74\n" + 
				"-32\n" + 
				"-48\n" + 
				"-11\n" + 
				"-80\n" + 
				"-88\n" + 
				"-33\n" + 
				"-67\n" + 
				"-96\n" + 
				"-67\n" + 
				"-49\n" + 
				"-55\n" + 
				"-101\n" + 
				"-8\n" + 
				"-77\n" + 
				"-33\n" + 
				"-93\n" + 
				"-22\n" + 
				"-21\n" + 
				"-99\n" + 
				"-33\n" + 
				"-12\n" + 
				"-111\n" + 
				"-105\n" + 
				"-77\n" + 
				"-76\n" + 
				"-90\n" + 
				"-63\n" + 
				"-76\n" + 
				"-55\n" + 
				"-65\n" + 
				"-106\n" + 
				"-56\n" + 
				"-93\n" + 
				"-121\n" + 
				"-31\n" + 
				"-86\n" + 
				"-102\n" + 
				"-116\n" + 
				"-120\n" + 
				"-17\n" + 
				"-95\n" + 
				"-110\n" + 
				"-128\n" + 
				"-122\n" + 
				"-135\n" + 
				"-133\n" + 
				"-124\n" + 
				"-50\n" + 
				"-32\n" + 
				"-86\n" + 
				"-11\n" + 
				"-127\n" + 
				"-42\n" + 
				"-9\n" + 
				"-41\n" + 
				"-28\n" + 
				"-93\n" + 
				"-13\n" + 
				"-16\n" + 
				"-8\n" + 
				"-138\n" + 
				"-111\n" + 
				"-103\n" + 
				"-25\n" + 
				"-22\n" + 
				"-133\n" + 
				"-52\n" + 
				"-27\n" + 
				"-6\n" + 
				"-67\n" + 
				"-72\n" + 
				"-115\n" + 
				"-133\n" + 
				"-146\n" + 
				"-46\n" + 
				"-128\n" + 
				"-99\n" + 
				"-115\n" + 
				"-16\n" + 
				"-113\n" + 
				"-105\n" + 
				"1\n" + 
				"-76\n" + 
				"-2\n" + 
				"1\n" + 
				"-66\n" + 
				"-164\n" + 
				"-87\n" + 
				"-8\n" + 
				"-92\n" + 
				"-180\n" + 
				"-137\n" + 
				"-39\n" + 
				"-127\n" + 
				"-124\n" + 
				"-66\n" + 
				"-96\n" + 
				"-185\n" + 
				"-13\n" + 
				"-65\n" + 
				"-178\n" + 
				"-16\n" + 
				"-32\n" + 
				"-24\n" + 
				"-84\n" + 
				"-49\n" + 
				"-7\n" + 
				"-198\n" + 
				"-101\n" + 
				"-119\n" + 
				"-187\n" + 
				"-71\n" + 
				"-125\n" + 
				"-130\n" + 
				"-72\n" + 
				"-130\n" + 
				"-43\n" + 
				"-136\n" + 
				"-171\n" + 
				"-32\n" + 
				"-210\n" + 
				"-69\n" + 
				"-195\n" + 
				"-207\n" + 
				"-197\n" + 
				"-190\n" + 
				"-117\n" + 
				"-196\n" + 
				"-143\n" + 
				"-128\n" + 
				"-155\n" + 
				"-160\n" + 
				"-53\n" + 
				"-205\n" + 
				"-15\n" + 
				"-86\n" + 
				"-227\n" + 
				"-128\n" + 
				"-115\n" + 
				"-58\n" + 
				"-96\n" + 
				"-52\n" + 
				"-100\n" + 
				"-41\n" + 
				"-84\n" + 
				"-61\n" + 
				"-50\n" + 
				"-91\n" + 
				"-158\n" + 
				"-30\n" + 
				"-230\n" + 
				"-125\n" + 
				"-177\n" + 
				"-181\n" + 
				"-47\n" + 
				"-43\n" + 
				"-241\n" + 
				"-52\n" + 
				"-102\n" + 
				"-161\n" + 
				"-16\n" + 
				"-130\n" + 
				"-21\n" + 
				"-22\n" + 
				"-249\n" + 
				"-78\n" + 
				"-101\n" + 
				"-51\n" + 
				"-229\n" + 
				"-148\n" + 
				"-132\n" + 
				"-213\n" + 
				"-264\n" + 
				"-175\n" + 
				"-128\n" + 
				"-102\n" + 
				"-26\n" + 
				"-86\n" + 
				"-84\n" + 
				"-100\n" + 
				"-132\n" + 
				"-228\n" + 
				"-118\n" + 
				"-46\n" + 
				"-77\n" + 
				"-230\n" + 
				"-98\n" + 
				"-193\n" + 
				"-191\n" + 
				"-142\n" + 
				"-193\n" + 
				"-183\n" + 
				"-58\n" + 
				"-59\n" + 
				"-254\n" + 
				"-256\n" + 
				"-108\n" + 
				"-12\n" + 
				"-46\n" + 
				"-11\n" + 
				"-143\n" + 
				"-22\n" + 
				"-121\n" + 
				"-68\n" + 
				"-282\n" + 
				"-94\n" + 
				"-22\n" + 
				"-172\n" + 
				"-246\n" + 
				"-174\n" + 
				"-76\n" + 
				"-3\n" + 
				"-117\n" + 
				"-237\n" + 
				"-258\n" + 
				"-29\n" + 
				"-105\n" + 
				"-32\n" + 
				"-177\n" + 
				"-125\n" + 
				"-70\n" + 
				"-176\n" + 
				"-113\n" + 
				"-152\n" + 
				"-227\n" + 
				"-298\n" + 
				"-199\n" + 
				"-179\n" + 
				"-162\n" + 
				"-241\n" + 
				"-230\n" + 
				"-8\n" + 
				"-202\n" + 
				"-296\n" + 
				"-194\n" + 
				"-82\n" + 
				"-188\n" + 
				"-136\n" + 
				"-24\n" + 
				"-171\n" + 
				"-185\n" + 
				"-272\n" + 
				"-124\n" + 
				"-306\n" + 
				"-230\n" + 
				"-249\n" + 
				"-64\n" + 
				"-139\n" + 
				"-143\n" + 
				"-293\n" + 
				"-218\n" + 
				"-167\n" + 
				"-208\n" + 
				"-254\n" + 
				"-171\n" + 
				"-119\n" + 
				"-82\n" + 
				"-284\n" + 
				"-262\n" + 
				"-252\n" + 
				"-92\n" + 
				"-230\n" + 
				"-193\n" + 
				"-173\n" + 
				"-269\n" + 
				"-173\n" + 
				"-13\n" + 
				"0\n" + 
				"-148\n" + 
				"-151\n" + 
				"-241\n" + 
				"-120\n" + 
				"-20\n" + 
				"-22\n" + 
				"-218\n" + 
				"-6\n" + 
				"-314\n" + 
				"-347\n" + 
				"-58\n" + 
				"-180\n" + 
				"-242\n" + 
				"-333\n" + 
				"-247\n" + 
				"-67\n" + 
				"-137\n" + 
				"-102\n" + 
				"-32\n" + 
				"-102\n" + 
				"-88\n" + 
				"-42\n" + 
				"-284\n" + 
				"-109\n" + 
				"-281\n" + 
				"-43\n" + 
				"-63\n" + 
				"-205\n" + 
				"-268\n" + 
				"-273\n" + 
				"-235\n" + 
				"-119\n" + 
				"-185\n" + 
				"-62\n" + 
				"-56\n" + 
				"-260\n" + 
				"-47\n" + 
				"-353\n" + 
				"-123\n" + 
				"-312\n" + 
				"0\n" + 
				"-76\n" + 
				"-352\n" + 
				"-365\n" + 
				"-284\n" + 
				"-105\n" + 
				"-62\n" + 
				"-165\n" + 
				"-292\n" + 
				"-5\n" + 
				"-46\n" + 
				"-31\n" + 
				"-116\n" + 
				"-147\n" + 
				"-34\n" + 
				"-149\n" + 
				"-79\n" + 
				"-139\n" + 
				"-132\n" + 
				"-84\n" + 
				"-58\n" + 
				"-130\n" + 
				"-125\n" + 
				"-188\n" + 
				"-227\n" + 
				"-2\n" + 
				"-220\n" + 
				"-88\n" + 
				"-96\n" + 
				"-38\n" + 
				"-308\n" + 
				"-214\n" + 
				"-357\n" + 
				"-19\n" + 
				"-410\n" + 
				"-292\n" + 
				"-150\n" + 
				"-151\n" + 
				"1\n" + 
				"-252\n" + 
				"-172\n" + 
				"-414\n" + 
				"-15\n" + 
				"-207\n" + 
				"-184\n" + 
				"-286\n" + 
				"-161\n" + 
				"-55\n" + 
				"-158\n" + 
				"-330\n" + 
				"-53\n" + 
				"-310\n" + 
				"-295\n" + 
				"-248\n" + 
				"-126\n" + 
				"-425\n" + 
				"-10\n" + 
				"-289\n" + 
				"-148\n" + 
				"-146\n" + 
				"-436\n" + 
				"-279\n" + 
				"-48\n" + 
				"-321\n" + 
				"-196\n" + 
				"-162\n" + 
				"-55\n" + 
				"-125\n" + 
				"-62\n" + 
				"-381\n" + 
				"-337\n" + 
				"-85\n" + 
				"-428\n" + 
				"-470\n" + 
				"-180\n" + 
				"-392\n" + 
				"-450\n" + 
				"-376\n" + 
				"-73\n" + 
				"-206\n" + 
				"-115\n" + 
				"-289\n" + 
				"-318\n" + 
				"-22\n" + 
				"-200\n" + 
				"-176\n" + 
				"-410\n" + 
				"-380\n" + 
				"-470\n" + 
				"-418\n" + 
				"-163\n" + 
				"-424\n" + 
				"-288\n" + 
				"-374\n" + 
				"-358\n" + 
				"-386\n" + 
				"-340\n" + 
				"-403\n" + 
				"-81\n" + 
				"-7\n" + 
				"-378\n" + 
				"1\n" + 
				"-320\n" + 
				"-323\n" + 
				"-288\n" + 
				"-439\n" + 
				"-437\n" + 
				"-90\n" + 
				"-159\n" + 
				"-379\n" + 
				"-69\n" + 
				"-236\n" + 
				"-168\n" + 
				"-232\n" + 
				"-232\n" + 
				"-42\n" + 
				"-257\n" + 
				"-437\n" + 
				"-40\n" + 
				"-390\n" + 
				"-241\n" + 
				"-54\n" + 
				"-247\n" + 
				"-76\n" + 
				"-325\n" + 
				"-351\n" + 
				"-259\n" + 
				"-328\n" + 
				"-283\n" + 
				"-5\n" + 
				"-169\n" + 
				"-114\n" + 
				"-252\n" + 
				"-131\n" + 
				"-223\n" + 
				"-446\n" + 
				"-482\n" + 
				"-7\n" + 
				"-285\n" + 
				"-486\n" + 
				"-260\n" + 
				"-421\n" + 
				"-498\n" + 
				"-32\n" + 
				"-182\n" + 
				"-317\n" + 
				"-201\n" + 
				"-370\n" + 
				"-518\n" + 
				"-129\n" + 
				"-359\n" + 
				"-67\n" + 
				"-209\n" + 
				"-541\n" + 
				"-323\n" + 
				"-132\n" + 
				"-197\n" + 
				"-70\n" + 
				"-171\n" + 
				"-258\n" + 
				"-372\n" + 
				"-228\n" + 
				"-4\n" + 
				"-360\n" + 
				"-144\n" + 
				"-307\n" + 
				"-226\n" + 
				"-533\n" + 
				"-435\n" + 
				"-318\n" + 
				"-284\n" + 
				"-284\n" + 
				"-150\n" + 
				"-539\n" + 
				"-46\n" + 
				"-81\n" + 
				"-144\n" + 
				"-188\n" + 
				"-264\n" + 
				"-136\n" + 
				"-138\n" + 
				"-106\n" + 
				"-65\n" + 
				"-262\n" + 
				"-250\n" + 
				"-176\n" + 
				"-261\n" + 
				"-112\n" + 
				"-227\n" + 
				"-304\n" + 
				"-159\n" + 
				"-425\n" + 
				"-117\n" + 
				"-441\n" + 
				"-111\n" + 
				"-468\n" + 
				"-2\n" + 
				"-84\n" + 
				"-197\n" + 
				"1\n" + 
				"-575\n" + 
				"-305\n" + 
				"-401\n" + 
				"-114\n" + 
				"-143\n" + 
				"-180\n" + 
				"-16\n" + 
				"-450\n" + 
				"-24\n" + 
				"-357\n" + 
				"-104\n" + 
				"-434\n" + 
				"-435\n" + 
				"-345\n" + 
				"-247\n" + 
				"-484\n" + 
				"-282\n" + 
				"-263\n" + 
				"-389\n" + 
				"-463\n" + 
				"-178\n" + 
				"-144\n" + 
				"-256\n" + 
				"-94\n" + 
				"-522\n" + 
				"-302\n" + 
				"-524\n" + 
				"-309\n" + 
				"-275\n" + 
				"-350\n" + 
				"-596\n" + 
				"-462\n" + 
				"-317\n" + 
				"-543\n" + 
				"-8\n" + 
				"-374\n" + 
				"-404\n" + 
				"-302\n" + 
				"-610\n" + 
				"-111\n" + 
				"-358\n" + 
				"2\n" + 
				"-353\n" + 
				"-397\n" + 
				"-165\n" + 
				"-324\n" + 
				"-574\n" + 
				"-618\n" + 
				"-168\n" + 
				"-636\n" + 
				"-389\n" + 
				"-609\n" + 
				"-54\n" + 
				"-121\n" + 
				"-256\n" + 
				"-604\n" + 
				"-588\n" + 
				"-454\n" + 
				"-100\n" + 
				"-212\n" + 
				"-65\n" + 
				"-300\n" + 
				"-592\n" + 
				"-43\n" + 
				"-230\n" + 
				"-652\n" + 
				"-638\n" + 
				"-67\n" + 
				"-499\n" + 
				"-614\n" + 
				"-419\n" + 
				"-577\n" + 
				"-96\n" + 
				"-257\n" + 
				"-519\n" + 
				"-458\n" + 
				"-14\n" + 
				"-26\n" + 
				"-370\n" + 
				"-187\n" + 
				"-319\n" + 
				"-528\n" + 
				"-436\n" + 
				"-87\n" + 
				"-673\n" + 
				"-535\n" + 
				"-473\n" + 
				"-670\n" + 
				"-594\n" + 
				"-589\n" + 
				"-629\n" + 
				"-180\n" + 
				"-13\n" + 
				"-668\n" + 
				"-369\n" + 
				"-679\n" + 
				"-587\n" + 
				"-624\n" + 
				"-123\n" + 
				"-363\n" + 
				"-241\n" + 
				"-343\n" + 
				"-259\n" + 
				"-123\n" + 
				"-319\n" + 
				"-608\n" + 
				"-470\n" + 
				"-336\n" + 
				"-291\n" + 
				"-676\n" + 
				"-535\n" + 
				"-226\n" + 
				"-11\n" + 
				"-224\n" + 
				"-43\n" + 
				"-30\n" + 
				"-605\n" + 
				"-670\n" + 
				"-544\n" + 
				"-248\n" + 
				"-609\n" + 
				"-144\n" + 
				"-328\n" + 
				"-177\n" + 
				"-360\n" + 
				"-628\n" + 
				"-51\n" + 
				"-724\n" + 
				"-407\n" + 
				"-625\n" + 
				"-433\n" + 
				"-192\n" + 
				"-455\n" + 
				"-603\n" + 
				"-581\n" + 
				"-33\n" + 
				"-696\n" + 
				"-160\n" + 
				"-464\n" + 
				"-510\n" + 
				"-3\n" + 
				"-144\n" + 
				"-113\n" + 
				"-87\n" + 
				"-519\n" + 
				"-263\n" + 
				"-161\n" + 
				"-94\n" + 
				"-716\n" + 
				"-484\n" + 
				"-509\n" + 
				"-615\n" + 
				"-373\n" + 
				"-734\n" + 
				"-686\n" + 
				"-732\n" + 
				"-395\n" + 
				"-163\n" + 
				"-432\n" + 
				"-26\n" + 
				"-716\n" + 
				"-599\n" + 
				"-596\n" + 
				"-648\n" + 
				"-91\n" + 
				"-716\n" + 
				"-540\n" + 
				"-429\n" + 
				"-456\n" + 
				"-744\n" + 
				"-344\n" + 
				"-298\n" + 
				"-689\n" + 
				"-428\n" + 
				"-119\n" + 
				"-323\n" + 
				"-196\n" + 
				"-41\n" + 
				"-602\n" + 
				"-724\n" + 
				"-413\n" + 
				"-444\n" + 
				"-614\n" + 
				"-331\n" + 
				"-697\n" + 
				"-115\n" + 
				"-7\n" + 
				"-409\n" + 
				"-272\n" + 
				"-672\n" + 
				"-224\n" + 
				"-732\n" + 
				"-203\n" + 
				"-37\n" + 
				"-397\n" + 
				"-794\n" + 
				"-161\n" + 
				"-512\n" + 
				"-664\n" + 
				"-193\n" + 
				"-245\n" + 
				"-490\n" + 
				"-439\n" + 
				"-696\n" + 
				"-661\n" + 
				"-717\n" + 
				"-424\n" + 
				"-308\n" + 
				"-481\n" + 
				"-215\n" + 
				"-658\n" + 
				"-705\n" + 
				"-389\n" + 
				"-90\n" + 
				"-619\n" + 
				"-297\n" + 
				"-670\n" + 
				"-125\n" + 
				"-119\n" + 
				"-268\n" + 
				"-553\n" + 
				"-227\n" + 
				"-733\n" + 
				"-142\n" + 
				"-333\n" + 
				"-52\n" + 
				"-609\n" + 
				"-795\n" + 
				"-422\n" + 
				"-202\n" + 
				"-579\n" + 
				"-397\n" + 
				"-431\n" + 
				"-561\n" + 
				"-140\n" + 
				"-467\n" + 
				"-688\n" + 
				"-486\n" + 
				"-493\n" + 
				"-279\n" + 
				"-457\n" + 
				"-295\n" + 
				"-181\n" + 
				"-823\n" + 
				"-808\n" + 
				"-495\n" + 
				"-620\n" + 
				"-652\n" + 
				"-80\n" + 
				"-22\n" + 
				"-26\n" + 
				"-769\n" + 
				"0\n" + 
				"-439\n" + 
				"-31\n" + 
				"-458\n" + 
				"-5\n" + 
				"-221\n" + 
				"-675\n" + 
				"-443\n" + 
				"-809\n" + 
				"-845\n" + 
				"-234\n" + 
				"-429\n" + 
				"-425\n" + 
				"-754\n" + 
				"-820\n" + 
				"-442\n" + 
				"-561\n" + 
				"-513\n" + 
				"-462\n" + 
				"-840\n" + 
				"-596\n" + 
				"-113\n" + 
				"-736\n" + 
				"-12\n" + 
				"-123\n" + 
				"-747\n" + 
				"-735\n" + 
				"-732\n" + 
				"-209\n" + 
				"-478\n" + 
				"-504\n" + 
				"-784\n" + 
				"-522\n" + 
				"-257\n" + 
				"-695\n" + 
				"-676\n" + 
				"-331\n" + 
				"-767\n" + 
				"-801\n" + 
				"-128\n" + 
				"-571\n" + 
				"-683\n" + 
				"-757\n" + 
				"-475\n" + 
				"-749\n" + 
				"-53\n" + 
				"-366\n" + 
				"-795\n" + 
				"-562\n" + 
				"-632\n" + 
				"-284\n" + 
				"-488\n" + 
				"-692\n" + 
				"-368\n" + 
				"-883\n" + 
				"-542\n" + 
				"-745\n" + 
				"-10\n" + 
				"-693\n" + 
				"-752\n" + 
				"-136\n" + 
				"-736\n" + 
				"-347\n" + 
				"-855\n" + 
				"-521\n" + 
				"-151\n" + 
				"-324\n" + 
				"-126\n" + 
				"-678\n" + 
				"-28\n" + 
				"-875\n" + 
				"-832\n" + 
				"-474\n" + 
				"-657\n" + 
				"-569\n" + 
				"-518\n" + 
				"-642\n" + 
				"-351\n" + 
				"-850\n" + 
				"-45\n" + 
				"-383\n" + 
				"-362\n" + 
				"-655\n" + 
				"-590\n" + 
				"-184\n" + 
				"-543\n" + 
				"-563\n" + 
				"-631\n" + 
				"-165\n" + 
				"-607\n" + 
				"-732\n" + 
				"-450\n" + 
				"-219\n" + 
				"-774\n" + 
				"-461\n" + 
				"-823\n" + 
				"-651\n" + 
				"-48\n" + 
				"-750\n" + 
				"-246\n" + 
				"-341\n" + 
				"-805\n" + 
				"-620\n" + 
				"-425\n" + 
				"-696\n" + 
				"-874\n" + 
				"-502\n" + 
				"-186\n" + 
				"-143\n" + 
				"-77\n" + 
				"-452\n" + 
				"-710\n" + 
				"-103\n" + 
				"-836\n" + 
				"-824\n" + 
				"-775\n" + 
				"-108\n" + 
				"-823\n" + 
				"-937\n" + 
				"-969\n" + 
				"-392\n" + 
				"-17\n" + 
				"-725\n" + 
				"-226\n" + 
				"-441\n" + 
				"-489\n" + 
				"-669\n" + 
				"-665\n" + 
				"-182\n" + 
				"-625\n" + 
				"-905\n" + 
				"-523\n" + 
				"-925\n" + 
				"-573\n" + 
				"-821\n" + 
				"-786\n" + 
				"-734\n" + 
				"-21\n" + 
				"-819\n" + 
				"-181\n" + 
				"-342\n" + 
				"-625\n" + 
				"-12\n" + 
				"-705\n" + 
				"-275\n" + 
				"-756\n" + 
				"-79" );
		System.out.println(twistyTrampolinesStranger.calculate());
}

}