%% extratags.fst
%
% Optionally, include additional morphological rules specific to
% some corpus identified by a tag.

#include "stemtypes.fst"

#extratag# = <epic>

#is_ios_epic# = <is_ios> (is<fem><nom><sg>)
