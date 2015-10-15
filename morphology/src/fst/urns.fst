% urns.fst
%
% The FST system works with 4 kinds of URNs:
% To parse the FST analysis string, we need to be able to recognize 3 of the 4 kinds of
% URNs as classes we group in FST variables.
%
% For morphological categories, we're only ever working with individual values or
% sets of values we construct on the fly, I think.
%s

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% VALUES TO HARVEST FROM LEXICA OF STEMS
%
% 1. Lexical entities
%
#lexicon# =<lexent.n47950><lexent.n71065><lexent.n19546><lexent.n50824><lexent.n67485><lexent.n84494><lexent.n64316><lexent.n6949><lexent.n81672><lexent.n88464><lexent.n87956><lexent.n786>

#persname#=<pn.null_pn>

% 2. Morphological stems
#stemurn# = <coretests.n64316_0><coretests.n6949_0><coretests.n81672_0><coretests.n88464_0><coretests.n87956_0><coretests.n786_0>



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% 3. VALUES FOR INFLECTIONAL PATTERNS
%
#verb1indic# =  <w_indicative.1><w_indicative.2><w_indicative.3><w_indicative.4><w_indicative.5><w_indicative.6><w_indicative.7><w_indicative.8><w_indicative.9><w_indicative.10><w_indicative.11><w_indicative.12><w_indicative.13><w_indicative.14><w_indicative.15><w_indicative.16><w_indicative.17><w_indicative.18><w_indicative.19><w_indicative.20><w_indicative.21><w_indicative.22><w_indicative.23><w_indicative.24><w_indicative.25><w_indicative.26><w_indicative.27><w_indicative.28><w_indicative.29><w_indicative.30><w_indicative.31><w_indicative.32><w_indicative.33><w_indicative.34><w_indicative.35><w_indicative.36><w_indicative.37><w_indicative.38><w_indicative.39><w_indicative.40><w_indicative.41><w_indicative.42><w_indicative.43><w_indicative.44><w_indicative.45><w_indicative.46><w_indicative.47><w_indicative.48><w_indicative.49><w_indicative.50><w_indicative.51><w_indicative.52><w_indicative.53><w_indicative.54><w_indicative.55><w_indicative.56><w_indicative.57><w_indicative.58><w_indicative.59><w_indicative.60><w_indicative.61><w_indicative.62><w_indicative.63><w_indicative.64><w_indicative.65><w_indicative.66><w_indicative.67><w_indicative.68><w_indicative.69><w_indicative.70><w_indicative.71><w_indicative.72>

#verb1subj# = <w_subjunctive.1> <w_subjunctive.2><w_subjunctive.3><w_subjunctive.4><w_subjunctive.5><w_subjunctive.6><w_subjunctive.7><w_subjunctive.8><w_subjunctive.9><w_subjunctive.10><w_subjunctive.11><w_subjunctive.12>


#imptvinfl# = <w_imperative.1><w_imperative.2><w_imperative.3><w_imperative.4><w_imperative.5><w_imperative.6><w_imperative.7><w_imperative.8><w_imperative.9><w_imperative.10><w_imperative.11><w_imperative.12>

#optativeinfl# = <w_optative.1><w_optative.2><w_optative.3><w_optative.4><w_optative.5><w_optative.6><w_optative.7><w_optative.8><w_optative.9><w_optative.10><w_optative.11><w_optative.12><w_optative.13><w_optative.14><w_optative.15><w_optative.16><w_optative.17><w_optative.18><w_optative.19><w_optative.20><w_optative.21><w_optative.22><w_optative.23><w_optative.24><w_optative.25><w_optative.26><w_optative.27><w_optative.28><w_optative.29><w_optative.30>

 #inflectionurn# =  #verb1indic# | #verb1subj# | #imptvinfl# | #optativeinfl#






 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 %
 % FURTHER URNS USED IN THE SYSTEM
 %
 % Morphological categories.  Collection to expand this to full URN already registered
 % since these are known values.
 %
 % Thus: lexical entities + lexicon of stems + inflectional pattern all in



#urn# = #lexicon# | #persname# | #stemurn# | #inflectionurn#
