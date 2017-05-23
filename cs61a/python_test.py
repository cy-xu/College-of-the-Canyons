class Link:
	empty = ()

	def __init__(self, first, rest=empty):
		self.first = first
		self.rest = rest
	def __len__(self):
		return 1 + len(self.rest)
	def __repr__(self):
		return "Link({}, {})".format(self.first, self.rest)

def swap_pairs(lst):
	if lst != Link.empty:
    	lst.first, lst.rest.first = lst.rest.first, lst.first
    	swap_pairs(lst.rest.rest)
def double_double(lst):
	'''if lst == Link.empty:
		return lst
	lst.first = lst.first * 2
	lst = Link(lst.first, lst)
	double_double(lst.rest.rest)'''
	if lst != Link.empty:
		lst.first = lst.first * 2
		double_double(lst.rest)
		lst.rest = Link(lst.first,lst.rest)

class Tree:
    def __init__(self, entry, branches=()):
        self.entry = entry
        self.branches = branches

	def __repr__(self):
		if self.branches:
			return ‘Tree({0}, {1})’.format(repr(self.entry), repr(self.branches))
		else:
			return ‘Tree({0})’.format(repr(self.entry))
def insert_everywhere(t,val):
	if t.is_leaf:
		return
	for b in t.branches:
		insert_everywhere(b,val)
	t.branches.append(Tree(val))
def tree_greater_than(t1,t2):
	if t1.is_leaf:
		if t1.root > t2.root:
			return 1
		return 0
	for b1,b2 in t1.branches,t2.branches:
		if b1.root > b2.root:
			return 1 + tree_greater_than(b1,b2)
		else:
			return tree_greater_than(b1,b2)